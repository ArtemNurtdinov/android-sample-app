package com.nefrit.core_db.di

import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.FeatureApiHolder
import com.nefrit.common.di.FeatureContainer
import com.nefrit.common.di.scope.ApplicationScope
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