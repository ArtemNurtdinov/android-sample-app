package com.nefrit.app

import android.app.Application
import com.nefrit.app.di.AppModule
import com.nefrit.app.di.DaggerAppComponent
import com.nefrit.core.di.ComponentDependenciesProvider
import com.nefrit.core.di.HasComponentDependencies
import javax.inject.Inject

open class App : Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider
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