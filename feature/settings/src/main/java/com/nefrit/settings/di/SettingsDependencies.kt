package com.nefrit.settings.di

import com.nefrit.common.resources.ResourceManager
import com.nefrit.settings.presentation.SettingsRouter

interface SettingsDependencies {

    fun resourceManager(): ResourceManager

    fun settingsRouter(): SettingsRouter
}