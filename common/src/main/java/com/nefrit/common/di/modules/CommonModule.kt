package com.nefrit.common.di.modules

import android.content.Context
import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.data.network.RxCallAdapterFactory
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.resources.ResourceManagerImpl
import com.nefrit.common.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }

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
        return NetworkApiCreator(okHttpClient, "test url", rxCallAdapterFactory)
    }
}