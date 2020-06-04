package com.nefrit.app

import android.app.Application
import com.nefrit.app.di.DaggerAppComponent
import com.nefrit.common.di.FeatureContainer
import com.nefrit.app.di.FeatureHolderManager
import javax.inject.Inject

open class App : Application(), FeatureContainer {

    @Inject lateinit var featureHolderManager: FeatureHolderManager

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