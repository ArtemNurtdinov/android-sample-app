package com.nefrit.app

import android.app.Application
import com.nefrit.app.di.AppModule
import com.nefrit.app.di.DaggerAppComponent
import javax.inject.Inject

open class App : Application(), jp.co.soramitsu.core_di.HasComponentDependencies {

    @Inject
    override lateinit var dependencies: jp.co.soramitsu.core_di.ComponentDependenciesProvider
        protected set

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()

        appComponent.inject(this)
    }
}