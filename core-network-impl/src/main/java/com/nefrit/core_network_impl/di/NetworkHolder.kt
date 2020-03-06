package com.nefrit.core_network_impl.di

import com.nefrit.common.di.CommonApi
import com.nefrit.core_di.FeatureApiHolder
import com.nefrit.core_di.FeatureContainer
import com.nefrit.core_di.scope.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class NetworkHolder @Inject constructor(
    featureContainer: FeatureContainer
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val networkDependencies = DaggerNetworkComponent_NetworkDependenciesComponent.builder()
            .commonApi(getFeature(CommonApi::class.java))
            .build()
        return DaggerNetworkComponent.builder()
            .networkDependencies(networkDependencies)
            .build()
    }
}