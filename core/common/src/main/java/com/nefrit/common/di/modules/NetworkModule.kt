package com.nefrit.common.di.modules

import com.nefrit.common.core.config.AppProperties
import com.nefrit.common.core.config.NetworkProperties
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.data.network.RxCallAdapterFactory
import com.nefrit.common.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @ApplicationScope
    fun provideNetworkProperties(appProperties: AppProperties): NetworkProperties {
        return appProperties.networkProperties()
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(networkProperties: NetworkProperties): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(networkProperties.connectTimeout, TimeUnit.SECONDS)
            .writeTimeout(networkProperties.writeTimeout, TimeUnit.SECONDS)
            .readTimeout(networkProperties.readTimeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @ApplicationScope
    fun provideRxCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @ApplicationScope
    fun provideRxCallAdapterFactoryWrapped(resourceManager: ResourceManager, origin: RxJava2CallAdapterFactory): RxCallAdapterFactory {
        return RxCallAdapterFactory(resourceManager, origin)
    }

    @Provides
    @ApplicationScope
    fun provideApiCreator(
        okHttpClient: OkHttpClient,
        rxCallAdapterFactory: RxCallAdapterFactory,
        appProperties: AppProperties,
    ): NetworkApiCreator {
        return NetworkApiCreator(okHttpClient, appProperties.getBaseUrl(), rxCallAdapterFactory)
    }
}