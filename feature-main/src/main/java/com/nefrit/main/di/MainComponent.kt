package com.nefrit.main.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.core.di.FeatureScope
import com.nefrit.main.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [
    MainDependencies::class
], modules = [
    MainModule::class
])
@FeatureScope
interface MainComponent {

    companion object {
        fun init(activity: AppCompatActivity): MainComponent {
            return DaggerMainComponent
                .builder()
                .withActivity(activity)
                .withDependencies(activity.findComponentDependencies())
                .build()
        }
    }

    @Component.Builder
    interface Builder {

        fun withDependencies(dep: MainDependencies): Builder

        @BindsInstance
        fun withActivity(activity: AppCompatActivity): Builder

        fun build(): MainComponent
    }

    fun inject(activity: MainActivity)

}