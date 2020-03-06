package com.nefrit.core_network_impl.di

import com.nefrit.common.resources.ResourceManager
import com.nefrit.core_di.scope.ApplicationScope
import com.nefrit.core_network_api.NetworkApiCreator
import com.nefrit.core_network_impl.NetworkApiCreatorImpl
import com.nefrit.core_network_impl.data.RxCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideRxCallAdapterFactory(resourceManager: ResourceManager): RxCallAdapterFactory {
        return RxCallAdapterFactory(resourceManager)
    }

    @Provides
    @ApplicationScope
    fun provideApiCreator(
        okHttpClient: OkHttpClient,
        rxCallAdapterFactory: RxCallAdapterFactory
    ): NetworkApiCreator {
        return NetworkApiCreatorImpl(okHttpClient, "test url", rxCallAdapterFactory)
    }
}