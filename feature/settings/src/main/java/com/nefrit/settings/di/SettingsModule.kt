package com.nefrit.settings.di

import com.nefrit.common.di.scope.FeatureScope
import com.nefrit.settings.data.SettingsRepositoryImpl
import com.nefrit.settings.domain.SettingsInteractor
import com.nefrit.settings.domain.SettingsRepository
import dagger.Module
import dagger.Provides

@Module
class SettingsModule {

    @Provides
    @FeatureScope
    fun provideSettingsRepository(settingsRepository: SettingsRepositoryImpl): SettingsRepository = settingsRepository

    @Provides
    @FeatureScope
    fun provideSettingsInteractor(repository: SettingsRepository): SettingsInteractor {
        return SettingsInteractor(repository)
    }
}