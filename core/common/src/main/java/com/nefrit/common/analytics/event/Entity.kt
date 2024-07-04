package com.nefrit.common.analytics.event

enum class Entity(val code: String) {
    VIEW_MODEL("viewmodel"),
    INTERACTOR("interactor"),
    REPOSITORY("repository"),
    ;

    companion object {
        fun getEntity(code: String): Entity = values().firstOrNull { it.code == code } ?: VIEW_MODEL
    }
}