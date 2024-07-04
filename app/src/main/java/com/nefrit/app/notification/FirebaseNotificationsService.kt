package com.nefrit.app.notification

import android.content.Intent
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.nefrit.app.MainActivity
import com.nefrit.notification.NotificationManagerWrapper
import javax.inject.Inject

class FirebaseNotificationsService : FirebaseMessagingService() {

    @Inject lateinit var notificationManagerWrapper: NotificationManagerWrapper

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        sendNotification(remoteMessage)
    }

    private fun sendNotification(remoteMessage: RemoteMessage) {
        val notificationIntent = Intent(this, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        val notification = NotificationManagerWrapper.SimpleNotification(
            title = remoteMessage.notification?.title.orEmpty(),
            text = remoteMessage.notification?.body.orEmpty(),
            intent = notificationIntent,
        )

        notificationManagerWrapper.notify(notification)
    }
}