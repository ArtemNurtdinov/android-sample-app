package com.nefrit.splash.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.core.di.FeatureScope
import com.nefrit.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [
    SplashDependencies::class
], modules = [
    SplashModule::class
])
@FeatureScope
interface SplashComponent {

    @Component.Builder
    interface Builder {

        fun withDependencies(dep: SplashDependencies): Builder

        @BindsInstance
        fun withActivity(activity: AppCompatActivity): Builder

        fun build(): SplashComponent
    }

    fun inject(activity: SplashActivity)

}