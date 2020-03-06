package com.nefrit.core_network_impl

import com.nefrit.core_network_api.NetworkApiCreator
import com.nefrit.core_network_impl.data.RxCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkApiCreatorImpl(
    private val okHttpClient: OkHttpClient,
    private val baseUrl: String,
    private val rxCallAdapter: RxCallAdapterFactory
) : NetworkApiCreator {

    override fun <T> create(service: Class<T>): T {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(rxCallAdapter)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(service)
    }
}