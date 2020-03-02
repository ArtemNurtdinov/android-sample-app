package com.nefrit.splash.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.splash.presentation.SplashActivity
import dagger.BindsInstance
import dagger.Component
import jp.co.soramitsu.core_di.scope.FeatureScope

@Component(
    dependencies = [
        SplashDependencies::class
    ],
    modules = [
        SplashModule::class
    ]
)
@FeatureScope
interface SplashComponent {

    companion object {

        fun init(activity: AppCompatActivity, deps: SplashDependencies): SplashComponent {
            return DaggerSplashComponent.factory().create(activity, deps)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: AppCompatActivity,
            deps: SplashDependencies
        ): SplashComponent
    }

    fun inject(activity: SplashActivity)
}