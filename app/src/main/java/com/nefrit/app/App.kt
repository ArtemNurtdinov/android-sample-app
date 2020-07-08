package com.nefrit.app

import android.app.Application
import com.nefrit.app.di.deps.ComponentDependenciesProvider
import com.nefrit.app.di.deps.FeatureHolderManager
import com.nefrit.app.di.deps.HasComponentDependencies
import com.nefrit.app.di.app.DaggerAppComponent
import com.nefrit.common.di.FeatureContainer
import javax.inject.Inject

open class App : Application(), FeatureContainer, HasComponentDependencies {

    @Inject lateinit var featureHolderManager: FeatureHolderManager

    override lateinit var dependencies: ComponentDependenciesProvider
        protected set

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }
}