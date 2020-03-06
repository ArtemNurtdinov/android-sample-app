package com.nefrit.app.di

import com.nefrit.core_di.FeatureApiHolder
import com.nefrit.core_di.FeatureHolderManager
import com.nefrit.core_di.scope.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class FeatureManagerModule {

    @ApplicationScope
    @Provides
    fun provideFeatureHolderManager(featureApiHolderMap: @JvmSuppressWildcards Map<Class<*>, FeatureApiHolder>): FeatureHolderManager {
        return FeatureHolderManager(featureApiHolderMap)
    }
}