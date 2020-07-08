package com.nefrit.users.di

import com.nefrit.common.di.CommonApi
import com.nefrit.core_db.di.DbApi
import com.nefrit.common.di.FeatureApiHolder
import com.nefrit.common.di.FeatureContainer
import com.nefrit.common.di.scope.ApplicationScope
import com.nefrit.users.UsersRouter
import javax.inject.Inject

@ApplicationScope
class UserFeatureHolder @Inject constructor(
    featureContainer: FeatureContainer,
    private val usersRouter: UsersRouter
) : FeatureApiHolder(featureContainer) {

    override fun initializeDependencies(): Any {
        val userFeatureDependencies = DaggerUserFeatureComponent_UserFeatureDependenciesComponent.builder()
            .commonApi(getFeature(CommonApi::class.java))
            .dbApi(getFeature(DbApi::class.java))
            .build()
        return DaggerUserFeatureComponent.builder()
            .withDependencies(userFeatureDependencies)
            .router(usersRouter)
            .build()
    }
}