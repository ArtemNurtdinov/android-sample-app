package com.nefrit.users.di

import com.nefrit.common.di.CommonApi
import com.nefrit.common.di.scope.FeatureScope
import com.nefrit.common.data.db.di.DbApi
import com.nefrit.users.presentation.UsersRouter
import com.nefrit.users.presentation.details.di.UserComponent
import com.nefrit.users.presentation.list.di.UsersComponent
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(
    dependencies = [
        UserFeatureDependencies::class
    ],
    modules = [
        UserFeatureModule::class
    ]
)
interface UserFeatureComponent : UserFeatureApi {

    fun usersComponentFactory(): UsersComponent.Factory

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
            DbApi::class
        ]
    )
    interface UserFeatureDependenciesComponent : UserFeatureDependencies
}