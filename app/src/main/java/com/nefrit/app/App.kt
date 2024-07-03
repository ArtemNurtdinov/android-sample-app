package com.nefrit.app

import android.app.Application
import com.nefrit.app.di.app.AppComponent
import com.nefrit.app.di.main.MainDependencies
import com.nefrit.app.di.main.MainDependenciesProvider
import com.nefrit.settings.di.SettingsDependencies
import com.nefrit.settings.presentation.di.SettingsDependenciesProvider
import com.nefrit.users.di.UserFeatureDependencies
import com.nefrit.users.di.UserFeatureDependenciesProvider

open class App : Application(), UserFeatureDependenciesProvider, SettingsDependenciesProvider, MainDependenciesProvider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }

    override fun provideUserFeatureDependencies(): UserFeatureDependencies {
        return appComponent
    }

    override fun provideSettingsDependencies(): SettingsDependencies {
        return appComponent
    }

    override fun provideMainDependencies(): MainDependencies {
        return appComponent
    }
}