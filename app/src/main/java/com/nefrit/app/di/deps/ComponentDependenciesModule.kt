package com.nefrit.app.di.deps

import com.nefrit.app.di.app.AppComponent
import com.nefrit.app.di.deps.ComponentDependencies
import com.nefrit.app.di.deps.ComponentDependenciesKey
import com.nefrit.app.di.main.MainDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ComponentDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    fun provideMainDependencies(component: AppComponent): ComponentDependencies
}