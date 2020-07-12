package com.nefrit.core

interface ResourceManager {

    fun getString(resource: Int): String

    fun getColor(res: Int): Int

    fun getQuantityString(id: Int, quantity: Int): String
}