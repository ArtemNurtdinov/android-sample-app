package com.nefrit.example.di

import com.nefrit.core.di.ApplicationScope
import com.nefrit.example.router.AppRouter
import com.nefrit.example.router.AppRouterImpl
import com.nefrit.main.MainRouter
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RouterModule {

    @Binds
    @ApplicationScope
    abstract fun bindMainRouter(router: AppRouterImpl): MainRouter
}