package com.nefrit.common.di

import android.content.Context
import com.nefrit.core_di.FeatureApiHolder
import com.nefrit.core_di.FeatureContainer
import com.nefrit.core_di.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class CommonHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val context: Context
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        return DaggerCommonComponent.builder()
            .context(context)
            .build()
    }
}