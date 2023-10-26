package com.nefrit.app.di.deps

import android.app.Activity
import com.nefrit.app.App
import dagger.MapKey
import kotlin.reflect.KClass

interface ComponentDependencies

typealias ComponentDependenciesProvider = Map<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies>

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ComponentDependenciesKey(val value: KClass<out ComponentDependencies>)

inline fun <reified T : ComponentDependencies> Activity.findComponentDependencies(): T {
    return findComponentDependenciesProvider()[T::class.java] as T
}

fun Activity.findComponentDependenciesProvider(): ComponentDependenciesProvider {
    return (application as? App)?.dependencies ?: throw IllegalStateException("Can not find suitable dagger provider for $this")
}