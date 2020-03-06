package com.nefrit.common.resources

import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes resource: Int): String

    fun getColor(res: Int): Int

    fun getQuantityString(id: Int, quantity: Int): String
}