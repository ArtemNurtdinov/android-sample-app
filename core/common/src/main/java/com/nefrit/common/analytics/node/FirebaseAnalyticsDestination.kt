package com.nefrit.common.analytics.node

import androidx.core.os.bundleOf
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.nefrit.common.analytics.AnalyticsSettings
import com.nefrit.common.analytics.event.BaseAnalyticsEvent
import io.reactivex.Completable
import javax.inject.Inject

class FirebaseAnalyticsDestination @Inject constructor() : AnalyticsDestination {

    private val firebaseAnalytics by lazy {
        Firebase.analytics
    }

    override fun applySettings(settings: AnalyticsSettings) = Unit

    override fun logEvents(events: List<BaseAnalyticsEvent>): Completable {
        return Completable.fromAction {
            events.forEach { event ->
                log(event)
            }
        }
    }

    override fun logEvent(event: BaseAnalyticsEvent): Completable {
        return Completable.fromAction {
            log(event)
        }
    }

    private fun log(event: BaseAnalyticsEvent) {
        val bundle = bundleOf(*event.value.map { it.key to it.value }.toTypedArray())
        val logEvent = "event_${event.clazz.simpleName}"

        firebaseAnalytics.logEvent(logEvent, bundle)
    }
}