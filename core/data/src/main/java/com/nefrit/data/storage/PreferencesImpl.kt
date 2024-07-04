package com.nefrit.data.storage

import android.content.Context
import android.content.SharedPreferences
import com.nefrit.common.core.preferences.Preferences

class PreferencesImpl(context: Context) : Preferences {

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
    }

    private val prefs: SharedPreferences = context.getSharedPreferences("config", Context.MODE_PRIVATE)

    override fun saveAccessToken(token: String) {
        prefs.edit().putString(KEY_ACCESS_TOKEN, token).apply()
    }

    override fun getAccessToken(): String {
        return prefs.getString(KEY_ACCESS_TOKEN, "") ?: ""
    }
}