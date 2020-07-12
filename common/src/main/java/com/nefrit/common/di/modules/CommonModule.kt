package com.nefrit.common.di.modules

import android.content.Context
import com.nefrit.core.ResourceManager
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