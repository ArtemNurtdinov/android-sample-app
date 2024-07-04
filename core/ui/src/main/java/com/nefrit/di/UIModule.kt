package com.nefrit.di

import android.app.NotificationManager
import android.content.Context
import com.nefrit.common.core.config.AppProperties
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.core.resources.ResourceManagerImpl
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.notification.NotificationManagerWrapper
import com.nefrit.notification.NotificationManagerWrapperImpl
import com.nefrit.common.utils.DateFormatter
import dagger.Module
import dagger.Provides

@Module
class UIModule {

    @Provides
    fun provideNotificationWrapper(context: Context, notificationManager: NotificationManager): NotificationManagerWrapper {
        return NotificationManagerWrapperImpl(context, notificationManager)
    }
}