package com.nefrit.data.storage

interface Preferences {

    fun saveAccessToken(token: String)

    fun getAccessToken(): String
}