package com.nefrit.app.di

import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION)
annotation class ComponentDependenciesKey(val value: KClass<out jp.co.soramitsu.core_di.ComponentDependencies>)