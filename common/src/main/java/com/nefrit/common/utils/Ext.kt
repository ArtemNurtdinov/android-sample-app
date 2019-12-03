package com.nefrit.common.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Service
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.nefrit.core.di.ComponentDependencies
import com.nefrit.core.di.ComponentDependenciesProvider
import com.nefrit.core.di.HasComponentDependencies

inline fun <reified T : ComponentDependencies> Fragment.findComponentDependencies(): T {
    return findComponentDependenciesProvider()[T::class.java] as T
}

inline fun <reified T : ComponentDependencies> Activity.findComponentDependencies(): T {
    return findComponentDependenciesProvider()[T::class.java] as T
}

inline fun <reified T : ComponentDependencies> Service.findComponentDependencies(): T {
    return findComponentDependenciesProvider()[T::class.java] as T
}

fun Fragment.findComponentDependenciesProvider(): ComponentDependenciesProvider {
    val hasDaggerProviders = when {
        activity?.application is HasComponentDependencies -> activity?.application as HasComponentDependencies
        else -> throw IllegalStateException("Can not find suitable dagger provider for $this")
    }
    return hasDaggerProviders.dependencies
}

fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun Activity.findComponentDependenciesProvider(): ComponentDependenciesProvider {
    val hasDaggerProviders = when {
        this.application is HasComponentDependencies -> this.application as HasComponentDependencies
        else -> throw IllegalStateException("Can not find suitable dagger provider for $this")
    }
    return hasDaggerProviders.dependencies
}

fun Service.findComponentDependenciesProvider(): ComponentDependenciesProvider {
    val hasDaggerProviders = when {
        this.application is HasComponentDependencies -> this.application as HasComponentDependencies
        else -> throw IllegalStateException("Can not find suitable dagger provider for $this")
    }
    return hasDaggerProviders.dependencies
}

fun Activity.showShortToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Activity.showShortToast(@StringRes msg: Int) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Double.getValueRepresentation(
    currency: String = "",
    abs: Boolean = false,
    onlyWholePart: Boolean = false
): String {
    val rub = this.toLong()

    var balanceRub = Math.abs(rub).toString().addSpaces(3)

    if (this < 0 && !abs) {
        balanceRub = "-$balanceRub"
    }

    val kopeck = Math.abs(Math.round((this - rub) * 100)).toInt()

    return if (kopeck == 0 || onlyWholePart) {
        "$balanceRub $currency"
    } else {
        val balanceKop = if (kopeck < 10) "0$kopeck" else kopeck.toString()
        "$balanceRub,$balanceKop $currency"
    }
}

fun String.addSpaces(chars: Int): String {
    val count = (length - 1) / chars

    val sb = StringBuilder(this)

    for (i in 1..count) {
        val spaceIndex = sb.length - (chars * i + i - 1)
        sb.insert(spaceIndex, " ")
    }

    return sb.toString()
}

@SuppressLint("NewApi")
fun Activity.setBarColorBackground(colorId: Int) {
    window.statusBarColor = ContextCompat.getColor(this, colorId)
}

fun <T> MutableLiveData<T>.setValueIfNew(newValue: T) {
    if (this.value != newValue) value = newValue
}

fun <T> MutableLiveData<T>.postValueIfNew(newValue: T) {
    if (this.value != newValue) postValue(newValue)
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}