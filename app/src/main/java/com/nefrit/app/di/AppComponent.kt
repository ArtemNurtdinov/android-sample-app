package com.nefrit.app.di

import com.nefrit.app.App
import com.nefrit.data.di.ApiModule
import com.nefrit.data.di.RepoModule
import com.nefrit.splash.di.SplashDependencies
import com.nefrit.user.di.UserDependencies
import com.nefrit.users.di.UsersDependencies
import dagger.Component
import jp.co.soramitsu.core_di.scope.ApplicationScope

@ApplicationScope
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        RouterModule::class,
        RepoModule::class,
        ComponentDependenciesModule::class
    ]
)
interface AppComponent : UsersDependencies, UserDependencies, SplashDependencies {

    fun inject(app: App)
}