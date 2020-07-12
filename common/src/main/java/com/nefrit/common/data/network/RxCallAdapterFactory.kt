package com.nefrit.common.data.network

import com.nefrit.core.ResourceManager
import com.nefrit.core.exceptions.BaseException
import io.reactivex.Single
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.IOException
import java.lang.reflect.Type

@Suppress("UNCHECKED_CAST")
class RxCallAdapterFactory(
    private val resourceManager: ResourceManager
) : CallAdapter.Factory() {

    private val origin = RxJava2CallAdapterFactory.create()

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        val adapter = origin.get(returnType, annotations, retrofit) ?: return null

        return RxCallAdapterWrapper(adapter as CallAdapter<out Any, Any>)
    }

    private inner class RxCallAdapterWrapper<R>(
        private val wrapped: CallAdapter<R, Any>
    ) : CallAdapter<R, Any> {

        override fun responseType(): Type {
            return wrapped.responseType()
        }

        override fun adapt(call: Call<R>): Any {
            val adapt = wrapped.adapt(call)

            return (adapt as Single<Any>)
                .onErrorResumeNext { Single.error(asRetrofitException(it)) }
        }

        private fun asRetrofitException(throwable: Throwable): BaseException {
            return when (throwable) {
                is HttpException -> {
                    val errorCode = throwable.response().code()
                    throwable.response().errorBody()?.close()
                    BaseException.httpError(errorCode, resourceManager.getString(com.nefrit.common.R.string.common_error_general_message))
                }
                is IOException -> BaseException.networkError(resourceManager.getString(com.nefrit.common.R.string.common_error_network), throwable)
                else -> BaseException.unexpectedError(throwable)
            }
        }
    }
}