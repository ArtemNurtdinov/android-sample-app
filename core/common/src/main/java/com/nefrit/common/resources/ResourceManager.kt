package com.nefrit.common.resources

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

interface ResourceManager {

    fun getString(@StringRes resource: Int): String

    fun getString(@StringRes id: Int, vararg formatArgs: Any): String

    fun getPluralString(@PluralsRes id: Int, quantity: Int): String

    fun getStringArray(@ArrayRes id: Int): Array<String>

    fun getColor(@ColorRes id: Int): Int

    fun getDrawable(@DrawableRes id: Int): Drawable?

    fun getBitmap(@DrawableRes id: Int): Bitmap?

    fun getDimen(@DimenRes id: Int): Float
}

class ResourceManagerImpl(
    private val context: Context,
) : ResourceManager {

    override fun getString(@StringRes resource: Int): String {
        return context.getString(resource)
    }

    override fun getString(@StringRes id: Int, vararg formatArgs: Any): String {
        return context.getString(id, *formatArgs)
    }

    override fun getPluralString(@PluralsRes id: Int, quantity: Int): String {
        return context.resources.getQuantityString(id, quantity)
    }

    override fun getStringArray(@ArrayRes id: Int): Array<String> {
        return context.resources.getStringArray(id)
    }

    override fun getColor(@ColorRes id: Int): Int {
        return ContextCompat.getColor(context, id)
    }

    override fun getDrawable(@DrawableRes id: Int): Drawable? {
        return ContextCompat.getDrawable(context, id)
    }

    override fun getBitmap(@DrawableRes id: Int): Bitmap? {
        return BitmapFactory.decodeResource(context.resources, id)
    }

    override fun getDimen(@DimenRes id: Int): Float {
        return context.resources.getDimension(id)
    }
}