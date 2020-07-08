package com.nefrit.app.di.app

import com.nefrit.app.App
import com.nefrit.app.di.deps.ComponentDependenciesModule
import com.nefrit.app.di.deps.ComponentHolderModule
import com.nefrit.app.di.main.MainDependencies
import com.nefrit.common.di.modules.CommonModule
import com.nefrit.common.di.modules.NetworkModule
import com.nefrit.common.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        NavigationModule::class,
        ComponentHolderModule::class,
        ComponentDependenciesModule::class,
        FeatureManagerModule::class
    ]
)
interface AppComponent : MainDependencies {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}