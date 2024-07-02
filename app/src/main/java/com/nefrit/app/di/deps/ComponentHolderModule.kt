package com.nefrit.app.di.deps

import com.nefrit.app.App
import com.nefrit.common.di.FeatureApiHolder
import com.nefrit.common.di.FeatureContainer
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.common.data.db.di.DbApi
import com.nefrit.common.data.db.di.DbHolder
import com.nefrit.settings.di.SettingsApi
import com.nefrit.settings.di.SettingsFeatureHolder
import com.nefrit.users.di.UserFeatureApi
import com.nefrit.users.di.UserFeatureHolder
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
    @ClassKey(UserFeatureApi::class)
    @IntoMap
    fun provideUserFeatureHolder(userFeatureHolder: UserFeatureHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(DbApi::class)
    @IntoMap
    fun provideDbFeature(dbHolder: DbHolder): FeatureApiHolder

    @ApplicationScope
    @Binds
    @ClassKey(SettingsApi::class)
    @IntoMap
    fun provideSettingsFeature(settingsFeatureHolder: SettingsFeatureHolder): FeatureApiHolder
}