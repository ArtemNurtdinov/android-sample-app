package com.nefrit.common.analytics.event

import com.nefrit.common.analytics.AnalyticsSettings

data class BaseAnalyticsEvent(
    val caseId: String,
    val action: String,
    val value: Map<String, String> = emptyMap(),
    val entity: Entity = Entity.VIEW_MODEL,
    val isError: Boolean = false,
    val eventDate: Long = System.currentTimeMillis(),
    val clazz: Class<*>,
) {
    fun needDrop(settings: AnalyticsSettings) = settings.ignoredEntities.contains(entity) ||
        settings.ignoredActions.contains(action) ||
        settings.ignoredCases.contains(caseId) ||
        (settings.needOnlyErrorsLogging && !isError)
}