package com.nefrit.app

import android.app.Application
import com.nefrit.app.di.app.AppComponent
import com.nefrit.app.di.deps.ComponentDependenciesProvider
import com.nefrit.app.di.deps.FeatureHolderManager
import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.FeatureContainer
import javax.inject.Inject

open class App : Application(), FeatureContainer {

    @Inject lateinit var featureHolderManager: FeatureHolderManager

    @Inject lateinit var dependencies: ComponentDependenciesProvider

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }

    override fun commonApi(): CommonApi {
        return appComponent
    }
}