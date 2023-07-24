package com.nefrit.common.core.storage

interface Preferences {

    fun saveAccessToken(token: String)

    fun getAccessToken(): String
}