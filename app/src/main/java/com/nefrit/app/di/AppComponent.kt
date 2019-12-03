package com.nefrit.app.di

import com.nefrit.data.di.ApiModule
import com.nefrit.data.di.RepoModule
import com.nefrit.users.di.UsersDependencies
import com.nefrit.app.App
import com.nefrit.core.di.ApplicationScope
import com.nefrit.user.di.UserDependencies
import com.nefrit.splash.di.SplashDependencies
import dagger.Component

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