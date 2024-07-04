package com.nefrit.settings.presentation.di

import androidx.fragment.app.Fragment
import com.nefrit.common.di.ScreenScope
import com.nefrit.settings.di.SettingsDependencies
import com.nefrit.settings.presentation.SettingsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        SettingsDependencies::class
    ],
    modules = [
        SettingsModule::class
    ]
)
@ScreenScope
interface SettingsFragmentComponent {

    companion object {
        fun create(fragment: Fragment, dependencies: SettingsDependencies): SettingsFragmentComponent {
            return DaggerSettingsFragmentComponent.factory().create(fragment, dependencies)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment,
            dependencies: SettingsDependencies
        ): SettingsFragmentComponent
    }

    fun inject(fragment: SettingsFragment)
}