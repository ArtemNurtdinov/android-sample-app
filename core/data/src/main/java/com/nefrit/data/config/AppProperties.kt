package com.nefrit.data.config

import android.content.Context
import com.nefrit.data.R
import java.util.Properties

@Suppress("UNCHECKED_CAST")
class AppProperties(context: Context) {

    private val properties: Map<String, String> = initProperties(context)

    private fun initProperties(context: Context): Map<String, String> {
        return context.resources.openRawResource(R.raw.config).use {
            val properties = Properties()
            properties.load(it)
            properties as Map<String, String>
        }
    }

    fun networkProperties(): NetworkProperties {
        val connectTimeout = properties["http.timeout.connect"]?.toLong() ?: 0
        val readTimeout = properties["http.timeout.read"]?.toLong() ?: 0
        val writeTimeout = properties["http.timeout.write"]?.toLong() ?: 0
        val logLevelProperty = properties["http.log.level"]
        val logLevel = when (logLevelProperty) {
            "BASIC" -> NetworkProperties.LogLevel.BASIC
            "BODY" -> NetworkProperties.LogLevel.BODY
            "HEADERS" -> NetworkProperties.LogLevel.HEADERS
            else -> NetworkProperties.LogLevel.NONE
        }
        return NetworkProperties(connectTimeout, readTimeout, writeTimeout, logLevel)
    }

    fun getBaseUrl(): String = properties["base_url"] ?: ""
}