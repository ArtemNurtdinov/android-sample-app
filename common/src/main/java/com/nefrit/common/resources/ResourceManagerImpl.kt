package com.nefrit.common.resources

import android.content.Context
import androidx.core.content.ContextCompat
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceManagerImpl @Inject constructor(
    private val context: Context
) : ResourceManager {

    override fun getString(resource: Int): String {
        return context.getString(resource)
    }

    override fun getColor(res: Int): Int {
        return ContextCompat.getColor(context, res)
    }

    override fun getQuantityString(id: Int, quantity: Int): String {
        return context.resources.getQuantityString(id, quantity)
    }
}