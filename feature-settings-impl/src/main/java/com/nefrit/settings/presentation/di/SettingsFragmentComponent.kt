package com.nefrit.settings.presentation.di

import androidx.fragment.app.Fragment
import com.nefrit.common.di.scope.ScreenScope
import com.nefrit.settings.presentation.SettingsFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        SettingsModule::class
    ]
)
@ScreenScope
interface SettingsFragmentComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment
        ): SettingsFragmentComponent
    }

    fun inject(fragment: SettingsFragment)
}