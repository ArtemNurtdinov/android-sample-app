package com.nefrit.core_db.di

import com.nefrit.common.di.CommonApi
import com.nefrit.core_di.FeatureApiHolder
import com.nefrit.core_di.FeatureContainer
import com.nefrit.core_di.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class DbHolder @Inject constructor(
    featureContainer: FeatureContainer
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val dbDependencies = DaggerDbComponent_DbDependenciesComponent.builder()
            .commonApi(getFeature(CommonApi::class.java))
            .build()
        return DaggerDbComponent.builder()
            .dbDependencies(dbDependencies)
            .build()
    }
}