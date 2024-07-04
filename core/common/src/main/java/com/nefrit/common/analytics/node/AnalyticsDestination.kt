package com.nefrit.common.analytics.node

import com.nefrit.common.analytics.AnalyticsSettings
import com.nefrit.common.analytics.event.BaseAnalyticsEvent
import io.reactivex.Completable

interface AnalyticsDestination {

    fun applySettings(settings: AnalyticsSettings)

    fun logEvents(events: List<BaseAnalyticsEvent>): Completable

    fun logEvent(event: BaseAnalyticsEvent): Completable
}