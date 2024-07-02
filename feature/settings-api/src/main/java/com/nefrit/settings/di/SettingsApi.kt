package com.nefrit.settings.di

import com.nefrit.settings.domain.interfaces.SettingsInteractor
import com.nefrit.settings.domain.interfaces.SettingsRepository

interface SettingsApi {

    fun provideSettingsRepository(): SettingsRepository

    fun provideSettingsInteractor(): SettingsInteractor
}