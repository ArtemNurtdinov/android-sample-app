package com.nefrit.users.di

import com.nefrit.common.di.CommonApi
import com.nefrit.core_db.di.DbApi
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.network.di.NetworkApi
import com.nefrit.users.UsersRouter
import com.nefrit.users.presentation.details.di.UserComponent
import com.nefrit.users.presentation.list.di.UsersComponent
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    dependencies = [
        UserFeatureDependencies::class
    ],
    modules = [
        UserFeatureModule::class
    ]
)
interface UserFeatureComponent : UserFeatureApi {

    fun usersComponentFactory(): UsersComponent.Builder

    fun userComponentFactory(): UserComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(usersRouter: UsersRouter): Builder

        fun withDependencies(deps: UserFeatureDependencies): Builder

        fun build(): UserFeatureComponent
    }

    @Component(
        dependencies = [
            CommonApi::class,
            NetworkApi::class,
            DbApi::class
        ]
    )
    interface UserFeatureDependenciesComponent : UserFeatureDependencies
}