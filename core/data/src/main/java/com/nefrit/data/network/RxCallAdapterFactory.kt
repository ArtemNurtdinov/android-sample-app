package com.nefrit.data.network

import com.nefrit.common.R
import com.nefrit.common.error.BaseError
import com.nefrit.common.resources.ResourceManager
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
    private val resourceManager: ResourceManager,
    private val origin: RxJava2CallAdapterFactory,
) : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        val adapter = origin.get(returnType, annotations, retrofit) ?: return null

        return RxCallAdapterWrapper(adapter as CallAdapter<out Any, Any>)
    }

    private inner class RxCallAdapterWrapper<T>(
        private val wrapped: CallAdapter<T, Any>,
    ) : CallAdapter<T, Any> {

        override fun responseType(): Type {
            return wrapped.responseType()
        }

        override fun adapt(call: Call<T>): Any {
            val adapt = wrapped.adapt(call)
            return (adapt as Single<Any>)
                .onErrorResumeNext { wrapCallError(it) }
        }

        private fun <T> wrapCallError(error: Throwable): Single<T> {
            return Single.error(mapException(error))
        }

        private fun mapException(throwable: Throwable): BaseError {
            return when (throwable) {
                is HttpException -> {
                    val errorCode = throwable.response()?.code() ?: 0
                    throwable.response()?.errorBody()?.close()
                    BaseError.connection(errorCode, resourceManager.getString(R.string.common_error_general_message))
                }

                is IOException -> BaseError.network(resourceManager.getString(R.string.common_error_network), throwable)
                else -> BaseError.unexpected(throwable)
            }
        }
    }
}