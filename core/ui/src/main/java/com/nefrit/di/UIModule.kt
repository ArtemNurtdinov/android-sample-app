package com.nefrit.di

import android.app.NotificationManager
import android.content.Context
import com.nefrit.notification.NotificationManagerWrapper
import com.nefrit.notification.NotificationManagerWrapperImpl
import dagger.Module
import dagger.Provides

@Module
class UIModule {

    @Provides
    fun provideNotificationWrapper(context: Context, notificationManager: NotificationManager): NotificationManagerWrapper {
        return NotificationManagerWrapperImpl(context, notificationManager)
    }
}