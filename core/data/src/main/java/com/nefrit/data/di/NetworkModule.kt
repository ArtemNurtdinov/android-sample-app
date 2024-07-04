package com.nefrit.data.di

import android.content.Context
import com.nefrit.common.di.ApplicationScope
import com.nefrit.common.resources.ResourceManager
import com.nefrit.data.config.AppProperties
import com.nefrit.data.config.NetworkProperties
import com.nefrit.data.network.NetworkApiCreator
import com.nefrit.data.network.RxCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideHttpLoggingInterceptor(networkProperties: NetworkProperties): HttpLoggingInterceptor {
        val logLevel = when(networkProperties.loggingLeveL) {
            NetworkProperties.LogLevel.NONE -> HttpLoggingInterceptor.Level.NONE
            NetworkProperties.LogLevel.BASIC -> HttpLoggingInterceptor.Level.BASIC
            NetworkProperties.LogLevel.BODY -> HttpLoggingInterceptor.Level.BODY
            NetworkProperties.LogLevel.HEADERS -> HttpLoggingInterceptor.Level.HEADERS
        }
        return HttpLoggingInterceptor().apply {
            level = logLevel
        }
    }

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(
        networkProperties: NetworkProperties,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(networkProperties.connectTimeout, TimeUnit.SECONDS)
            .writeTimeout(networkProperties.writeTimeout, TimeUnit.SECONDS)
            .readTimeout(networkProperties.readTimeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        builder.addInterceptor(loggingInterceptor)

        return builder.build()
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

    @Provides
    @ApplicationScope
    fun provideAppProperties(context: Context): AppProperties {
        return AppProperties(context)
    }
}