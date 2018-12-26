package com.nefrit.core.interfaces

typealias ComponentDependenciesProvider = Map<Class<out ComponentDependencies>, @JvmSuppressWildcards ComponentDependencies>

interface HasComponentDependencies {
    val dependencies: ComponentDependenciesProvider
}