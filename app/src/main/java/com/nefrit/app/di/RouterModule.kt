package com.nefrit.app.di

import com.nefrit.app.router.AppRouterImpl
import com.nefrit.splash.domain.SplashRouter
import com.nefrit.users.domain.UsersRouter
import dagger.Binds
import dagger.Module
import jp.co.soramitsu.core_di.scope.ApplicationScope

@Module
abstract class RouterModule {

    @Binds
    @ApplicationScope
    abstract fun bindUsersRouter(router: AppRouterImpl): UsersRouter

    @Binds
    @ApplicationScope
    abstract fun bindSplashRouter(router: AppRouterImpl): SplashRouter
}