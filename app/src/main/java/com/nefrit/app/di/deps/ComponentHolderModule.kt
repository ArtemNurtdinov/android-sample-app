package com.nefrit.app.di.deps

import com.nefrit.app.App
import com.nefrit.common.di.FeatureApiHolder
import com.nefrit.common.di.FeatureContainer
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.settings.di.SettingsApi
import com.nefrit.settings.di.SettingsFeatureHolder
import com.nefrit.users.di.UserFeatureApi
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ComponentHolderModule {

    @ApplicationScope
    @Binds
    fun provideFeatureContainer(application: App): FeatureContainer

    @ApplicationScope
    @Binds
    @ClassKey(SettingsApi::class)
    @IntoMap
    fun provideSettingsFeature(settingsFeatureHolder: SettingsFeatureHolder): FeatureApiHolder
}