package com.nefrit.second.di

import androidx.appcompat.app.AppCompatActivity
import com.nefrit.core.di.FeatureScope
import com.nefrit.second.SecondActivity
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [
    SecondDependencies::class
], modules = [
    SecondModule::class
])
@FeatureScope
interface SecondComponent {

    @Component.Builder
    interface Builder {

        fun withDependencies(dep: SecondDependencies): Builder

        @BindsInstance
        fun withActivity(activity: AppCompatActivity): Builder

        fun build(): SecondComponent
    }

    fun inject(activity: SecondActivity)

}