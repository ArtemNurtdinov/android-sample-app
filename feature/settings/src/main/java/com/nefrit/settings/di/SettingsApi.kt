package com.nefrit.settings.di

import com.nefrit.settings.domain.SettingsInteractor
import com.nefrit.settings.domain.SettingsRepository

interface SettingsApi {

    fun provideSettingsRepository(): SettingsRepository

    fun provideSettingsInteractor(): SettingsInteractor
}