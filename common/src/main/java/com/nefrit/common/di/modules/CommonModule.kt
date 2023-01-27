package com.nefrit.common.di.modules

import android.content.Context
import com.nefrit.common.core.config.AppProperties
import com.nefrit.common.core.ResourceManager
import com.nefrit.common.core.storage.Preferences
import com.nefrit.common.data.storage.PreferencesImpl
import com.nefrit.common.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManager(context)
    }

    @Provides
    @ApplicationScope
    fun provideAppProperties(context: Context): AppProperties {
        return AppProperties(context)
    }

    @Provides
    @ApplicationScope
    fun providePreferences(context: Context): Preferences {
        return PreferencesImpl(context)
    }
}