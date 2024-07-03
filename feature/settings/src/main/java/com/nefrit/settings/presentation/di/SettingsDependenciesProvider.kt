package com.nefrit.settings.presentation.di

import com.nefrit.settings.di.SettingsDependencies

interface SettingsDependenciesProvider {

    fun provideSettingsDependencies(): SettingsDependencies
}