package com.nefrit.example.di

import com.nefrit.core.di.ApplicationScope
import com.nefrit.data.di.ApiModule
import com.nefrit.data.di.RepoModule
import com.nefrit.main.di.MainDependencies
import com.nefrit.example.App
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        RepoModule::class,
        ComponentDependenciesModule::class
    ]
)
interface AppComponent : MainDependencies {

    fun inject(app: App)
}