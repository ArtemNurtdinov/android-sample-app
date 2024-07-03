package com.nefrit.settings.di

import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.scope.FeatureScope
import com.nefrit.settings.presentation.SettingsRouter
import com.nefrit.settings.presentation.di.SettingsFragmentComponent
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        SettingsDependencies::class
    ],
    modules = [
        SettingsModule::class
    ]
)
interface SettingsComponent : SettingsApi {

    fun settingsFragmentComponentFactory(): SettingsFragmentComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(router: SettingsRouter): Builder

        fun withDependencies(deps: SettingsDependencies): Builder

        fun build(): SettingsComponent
    }

    @Component(
        dependencies = [
            CommonApi::class
        ]
    )
    interface SettingsDependenciesComponent : SettingsDependencies
}