package com.nefrit.splash.di

import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.splash.SplashRouter
import com.nefrit.splash.presentation.di.SplashComponent
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        SplashFeatureDependencies::class
    ],
    modules = [
        SplashFeatureModule::class
    ]
)
@ApplicationScope
interface SplashFeatureComponent : SplashFeatureApi {

    fun splashComponentFactory(): SplashComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(splashRouter: SplashRouter): Builder

        fun withDependencies(deps: SplashFeatureDependencies): Builder

        fun build(): SplashFeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class
        ]
    )
    interface SplashFeatureDependenciesComponent : SplashFeatureDependencies
}