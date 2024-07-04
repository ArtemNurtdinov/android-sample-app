package com.nefrit.settings.presentation.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nefrit.common.resources.ResourceManager
import com.nefrit.ui.viewmodel.ViewModelKey
import com.nefrit.ui.viewmodel.ViewModelModule
import com.nefrit.settings.data.SettingsRepositoryImpl
import com.nefrit.settings.domain.SettingsInteractor
import com.nefrit.settings.domain.SettingsRepository
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

    @Provides
    fun provideSettingsRepository(settingsRepository: SettingsRepositoryImpl): SettingsRepository = settingsRepository

    @Provides
    fun provideSettingsInteractor(repository: SettingsRepository): SettingsInteractor {
        return SettingsInteractor(repository)
    }
}