package com.nefrit.app.di

import com.nefrit.app.navigation.Navigator
import com.nefrit.core_di.scope.ApplicationScope
import com.nefrit.splash.SplashRouter
import com.nefrit.users.UsersRouter
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideMainRouter(navigator: Navigator): UsersRouter = navigator

    @ApplicationScope
    @Provides
    fun provideSplashRouter(navigator: Navigator): SplashRouter = navigator
}