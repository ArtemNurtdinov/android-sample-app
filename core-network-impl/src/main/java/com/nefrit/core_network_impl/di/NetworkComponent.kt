package com.nefrit.core_network_impl.di

import com.nefrit.common.di.CommonApi
import com.nefrit.core_di.scope.ApplicationScope
import com.nefrit.core_network_api.di.NetworkApi
import dagger.Component

@Component(
    modules = [
        NetworkModule::class
    ],
    dependencies = [
        NetworkDependencies::class
    ]
)
@ApplicationScope
abstract class NetworkComponent : NetworkApi {

    @Component(
        dependencies = [
            CommonApi::class
        ]
    )
    interface NetworkDependenciesComponent : NetworkDependencies
}