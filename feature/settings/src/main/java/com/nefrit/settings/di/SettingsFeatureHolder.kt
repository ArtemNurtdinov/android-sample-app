package com.nefrit.settings.di

import com.nefrit.common.di.FeatureApiHolder
import com.nefrit.common.di.FeatureContainer
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.settings.presentation.SettingsRouter
import javax.inject.Inject

@ApplicationScope
class SettingsFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val settingsRouter: SettingsRouter,
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val settingsDependencies = DaggerSettingsComponent_SettingsDependenciesComponent.builder()
            .commonApi(commonApi())
            .build()
        return DaggerSettingsComponent.builder()
            .withDependencies(settingsDependencies)
            .router(settingsRouter)
            .build()
    }
}