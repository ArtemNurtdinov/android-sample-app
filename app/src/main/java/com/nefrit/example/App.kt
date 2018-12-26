package com.nefrit.example

import android.app.Application
import com.nefrit.core.interfaces.ComponentDependenciesProvider
import com.nefrit.core.interfaces.HasComponentDependencies
import com.nefrit.example.di.AppModule
import com.nefrit.example.di.DaggerAppComponent
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