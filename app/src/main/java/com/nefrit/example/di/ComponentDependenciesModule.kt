package com.nefrit.example.di

import com.nefrit.core.interfaces.ComponentDependencies
import com.nefrit.main.di.MainDependencies
import com.nefrit.second.di.SecondDependencies
import com.nefrit.splash.di.SplashDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ComponentDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    abstract fun provideMainDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SecondDependencies::class)
    abstract fun provideSecondDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SplashDependencies::class)
    abstract fun provideSplashependencies(component: AppComponent): ComponentDependencies
}