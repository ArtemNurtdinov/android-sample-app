package com.nefrit.common.di.modules

import android.app.NotificationManager
import android.content.Context
import com.nefrit.common.core.config.AppProperties
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.core.resources.ResourceManagerImpl
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.common.notification.NotificationManagerWrapper
import com.nefrit.common.notification.NotificationManagerWrapperImpl
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
    @ApplicationScope
    fun provideAppProperties(context: Context): AppProperties {
        return AppProperties(context)
    }

    @Provides
    fun provideDateFormatter(): DateFormatter {
        return DateFormatter()
    }

    @Provides
    fun provideNotificationWrapper(context: Context, notificationManager: NotificationManager): NotificationManagerWrapper {
        return NotificationManagerWrapperImpl(context, notificationManager)
    }
}