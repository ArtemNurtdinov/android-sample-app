package com.nefrit.data.config

data class NetworkProperties(
    val connectTimeout: Long,
    val readTimeout: Long,
    val writeTimeout: Long,
    val loggingLeveL: LogLevel
) {
    enum class LogLevel {
        NONE,
        BASIC,
        BODY,
        HEADERS
    }
}