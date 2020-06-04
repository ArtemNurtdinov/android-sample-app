package com.nefrit.common.di

import android.content.Context
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.resources.ResourceManagerImpl
import com.nefrit.common.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }
}