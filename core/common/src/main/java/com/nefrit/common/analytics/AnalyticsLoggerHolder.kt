package com.nefrit.common.analytics

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.nefrit.common.analytics.event.BaseAnalyticsEvent
import com.nefrit.common.analytics.event.Entity

private const val LIST_ITEMS_DIVIDER = ','

object AnalyticsLoggerHolder {

    private var logger: AnalyticsLogger? = null
    private var settings = AnalyticsSettings()

    private val remoteSettings by lazy { FirebaseRemoteConfig.getInstance() }

    fun init(logger: AnalyticsLogger) {
        this.logger = logger
        updateSettings()
    }

    fun getLogger() = logger

    private fun updateSettings() {
        fun String.getList() = split(LIST_ITEMS_DIVIDER)

        fun List<String>.getString() = when (isEmpty()) {
            true -> ""

            false -> reduce { values, value -> "$values$LIST_ITEMS_DIVIDER$value" }
        }

        remoteSettings.setDefaultsAsync(
            mapOf(
                IGNORED_CASE to settings.ignoredCases.getString(),
                IGNORED_ENTITIES to settings.ignoredEntities.map { it.code }.getString(),
                IGNORED_ACTIONS to settings.ignoredActions.getString(),
                NEED_ONLY_ERRORS_LOGGING to settings.needOnlyErrorsLogging,
                LOG_EXPORT_SYNC_TIME to settings.logExportSyncTime,
                MAX_LOG_ELEMENTS to settings.maxLogElements,
            ),
        )

        remoteSettings.activate()
        remoteSettings.fetch(0).addOnSuccessListener {
            settings = AnalyticsSettings(
                ignoredCases = remoteSettings.getString(IGNORED_CASE).getList(),
                ignoredEntities = remoteSettings.getString(IGNORED_ENTITIES).getList().map(
                    Entity::getEntity,
                ),
                ignoredActions = remoteSettings.getString(IGNORED_ACTIONS).getList(),
                needOnlyErrorsLogging = remoteSettings.getBoolean(
                    NEED_ONLY_ERRORS_LOGGING,
                ),
                logExportSyncTime = remoteSettings.getLong(
                    LOG_EXPORT_SYNC_TIME,
                ).toInt(),
                maxLogElements = remoteSettings.getLong(MAX_LOG_ELEMENTS).toInt(),
            )
            logger?.applySettings(settings)
        }
    }
}

fun Any.logViewModelEvent(
    caseId: String,
    action: String,
    values: Map<String, String> = emptyMap(),
) = logEvent(
    caseId = caseId,
    action = action,
    hasError = false,
    entity = Entity.VIEW_MODEL,
    values = values,
    clazz = javaClass,
)

fun Any.logViewModelErrorEvent(
    caseId: String,
    action: String,
    values: Map<String, String> = emptyMap(),
) = logEvent(
    caseId = caseId,
    action = action,
    hasError = true,
    entity = Entity.VIEW_MODEL,
    values = values,
    clazz = javaClass,
)

fun Any.logInteractorEvent(
    caseId: String,
    action: String,
    values: Map<String, String> = emptyMap(),
) = logEvent(
    caseId = caseId,
    action = action,
    hasError = false,
    entity = Entity.INTERACTOR,
    values = values,
    clazz = javaClass,
)

fun Any.logInteractorErrorEvent(
    caseId: String,
    action: String,
    values: Map<String, String> = emptyMap(),
) = logEvent(
    caseId = caseId,
    action = action,
    hasError = true,
    entity = Entity.INTERACTOR,
    values = values,
    clazz = javaClass,
)

fun Any.logRepositoryEvent(
    caseId: String,
    action: String,
    values: Map<String, String> = emptyMap(),
) = logEvent(
    caseId = caseId,
    action = action,
    hasError = false,
    entity = Entity.INTERACTOR,
    values = values,
    clazz = javaClass,
)

fun Any.logRepositoryErrorEvent(
    caseId: String,
    action: String,
    values: Map<String, String> = emptyMap(),
) = logEvent(
    caseId = caseId,
    action = action,
    hasError = true,
    entity = Entity.INTERACTOR,
    values = values,
    clazz = javaClass,
)

private fun logEvent(caseId: String, action: String, entity: Entity, hasError: Boolean, values: Map<String, String>, clazz: Class<*>) {
    AnalyticsLoggerHolder.getLogger()?.logEvent(
        BaseAnalyticsEvent(
            caseId = caseId,
            action = action,
            entity = entity,
            isError = hasError,
            value = values,
            clazz = clazz,
        ),
    )
}