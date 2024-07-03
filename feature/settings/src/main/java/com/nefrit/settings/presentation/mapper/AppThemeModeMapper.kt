package com.nefrit.settings.presentation.mapper

import androidx.appcompat.app.AppCompatDelegate
import com.nefrit.settings.presentation.view.AppThemeView
import javax.inject.Inject

class AppThemeModeMapper @Inject constructor() {

    fun mapAppThemeMode(mode: Int): AppThemeView.Mode {
        return when (mode) {
            AppCompatDelegate.MODE_NIGHT_NO -> AppThemeView.Mode.LIGHT
            AppCompatDelegate.MODE_NIGHT_YES -> AppThemeView.Mode.DARK
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY -> AppThemeView.Mode.AUTO_BATTERY
            else -> AppThemeView.Mode.FOLLOW_SYSTEM
        }
    }
}