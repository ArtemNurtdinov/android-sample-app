package com.nefrit.splash.di

import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.FeatureApiHolder
import com.nefrit.common.di.FeatureContainer
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.splash.SplashRouter
import javax.inject.Inject

@ApplicationScope
class SplashFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val splashRouter: SplashRouter
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val splashFeatureDependencies = DaggerSplashFeatureComponent_SplashFeatureDependenciesComponent.builder()
            .commonApi(getFeature(CommonApi::class.java))
            .build()
        return DaggerSplashFeatureComponent.builder()
            .withDependencies(splashFeatureDependencies)
            .router(splashRouter)
            .build()
    }
}