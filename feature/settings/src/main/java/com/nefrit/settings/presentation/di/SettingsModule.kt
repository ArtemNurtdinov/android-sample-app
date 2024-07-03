package com.nefrit.settings.presentation.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.di.viewmodel.ViewModelKey
import com.nefrit.common.di.viewmodel.ViewModelModule
import com.nefrit.settings.presentation.SettingsViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelModule::class
    ]
)
class SettingsModule {

    @Provides
    fun provideSettingsViewModel(fragment: Fragment, factory: ViewModelProvider.Factory): SettingsViewModel {
        return ViewModelProvider(fragment, factory)[SettingsViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun provideViewModel(resourceManager: ResourceManager): ViewModel {
        return SettingsViewModel(resourceManager)
    }
}