package com.nefrit.app.di

import com.nefrit.app.App
import com.nefrit.core_di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        ComponentHolderModule::class,
        FeatureManagerModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}