package com.nefrit.splash.presentation.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.core_di.scope.FeatureScope
import com.nefrit.splash.presentation.SplashActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        SplashModule::class
    ]
)
@FeatureScope
interface SplashComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: AppCompatActivity
        ): SplashComponent
    }

    fun inject(activity: SplashActivity)
}