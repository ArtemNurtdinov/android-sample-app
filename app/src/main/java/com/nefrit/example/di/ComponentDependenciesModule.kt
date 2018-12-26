package com.nefrit.example.di

import com.nefrit.core.interfaces.ComponentDependencies
import com.nefrit.main.di.MainDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ComponentDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    abstract fun provideMainDependencies(component: AppComponent): ComponentDependencies
}