package com.nefrit.app.di

import com.nefrit.core.di.ApplicationScope
import com.nefrit.app.router.AppRouterImpl
import com.nefrit.main.MainRouter
import com.nefrit.splash.SplashRouter
import dagger.Binds
import dagger.Module

@Module
abstract class RouterModule {

    @Binds
    @ApplicationScope
    abstract fun bindMainRouter(router: AppRouterImpl): MainRouter

    @Binds
    @ApplicationScope
    abstract fun bindSplashRouter(router: AppRouterImpl): SplashRouter

}