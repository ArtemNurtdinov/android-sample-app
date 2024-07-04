package com.nefrit.common.analytics

import com.nefrit.common.analytics.event.Entity

const val IGNORED_CASE = "ignoredCases"
const val IGNORED_ENTITIES = "ignoredEntities"
const val IGNORED_ACTIONS = "ignoredActions"
const val NEED_ONLY_ERRORS_LOGGING = "onlyErrorsLogging"
const val LOG_EXPORT_SYNC_TIME = "logExportSyncTime"
const val MAX_LOG_ELEMENTS = "maxLogElements"

data class AnalyticsSettings(
    val ignoredCases: List<String> = emptyList(),
    val ignoredEntities: List<Entity> = listOf(Entity.INTERACTOR, Entity.REPOSITORY),
    val ignoredActions: List<String> = emptyList(),
    val needOnlyErrorsLogging: Boolean = false,
    val logExportSyncTime: Int = 60,
    val maxLogElements: Int = 100,
    val needSendToFirebase: Boolean = true,
)