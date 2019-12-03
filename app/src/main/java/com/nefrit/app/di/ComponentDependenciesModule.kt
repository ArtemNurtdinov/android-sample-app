package com.nefrit.app.di

import com.nefrit.core.di.ComponentDependencies
import com.nefrit.users.di.UsersDependencies
import com.nefrit.user.di.UserDependencies
import com.nefrit.splash.di.SplashDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ComponentDependenciesModule private constructor() {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(UsersDependencies::class)
    abstract fun provideMainDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(UserDependencies::class)
    abstract fun provideSecondDependencies(component: AppComponent): ComponentDependencies

    @Binds
    @IntoMap
    @ComponentDependenciesKey(SplashDependencies::class)
    abstract fun provideSplashDependencies(component: AppComponent): ComponentDependencies
}