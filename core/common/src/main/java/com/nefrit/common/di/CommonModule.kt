package com.nefrit.common.di

import android.content.Context
import com.nefrit.common.analytics.AnalyticsLogger
import com.nefrit.common.analytics.AnalyticsLoggerImpl
import com.nefrit.common.analytics.node.AnalyticsDestination
import com.nefrit.common.analytics.node.FirebaseAnalyticsDestination
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.resources.ResourceManagerImpl
import com.nefrit.common.utils.DateFormatter
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }

    @Provides
    fun provideDateFormatter(): DateFormatter {
        return DateFormatter()
    }

    @Provides
    @ApplicationScope
    fun provideAnalyticsDestination(): AnalyticsDestination {
        return FirebaseAnalyticsDestination()
    }

    @Provides
    @ApplicationScope
    fun provideAnalyticsLogger(destination: AnalyticsDestination): AnalyticsLogger {
        return AnalyticsLoggerImpl(destination)
    }
}