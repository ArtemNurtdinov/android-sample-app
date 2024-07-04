package com.nefrit.common.analytics

import com.nefrit.common.analytics.event.BaseAnalyticsEvent
import com.nefrit.common.analytics.node.AnalyticsDestination
import com.nefrit.common.utils.plusAssign
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

interface AnalyticsLogger {

    fun applySettings(settings: AnalyticsSettings)

    fun logEvent(event: BaseAnalyticsEvent)

    fun logEvents(events: List<BaseAnalyticsEvent>)

    fun onDestroy()
}

class AnalyticsLoggerImpl @Inject constructor(
    private val firebaseDestination: AnalyticsDestination,
) : AnalyticsLogger {

    private val disposables = CompositeDisposable()

    private var needSendToFirebase = true

    private val _firebaseDestination: AnalyticsDestination?
        get() = when (needSendToFirebase) {
            true -> firebaseDestination
            false -> null
        }

    init {
        applySettings(AnalyticsSettings())
    }

    override fun applySettings(settings: AnalyticsSettings) {
        needSendToFirebase = settings.needSendToFirebase

        _firebaseDestination?.applySettings(settings)
    }

    override fun logEvent(event: BaseAnalyticsEvent) {
        logEvents(listOf(event))
    }

    override fun logEvents(events: List<BaseAnalyticsEvent>) {
        _firebaseDestination?.let {
            disposables += it.logEvents(events).subscribe()
        }
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}