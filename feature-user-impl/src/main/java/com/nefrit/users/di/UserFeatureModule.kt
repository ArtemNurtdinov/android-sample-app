package com.nefrit.users.di

import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.di.scope.FeatureScope
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.interfaces.UserRepository
import com.nefrit.users.data.network.UserApi
import com.nefrit.users.data.network.UserApiImpl
import com.nefrit.users.data.repository.UserRepositoryImpl
import com.nefrit.users.domain.UsersInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class UserFeatureModule {

    @Provides
    @FeatureScope
    fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository = userRepository

    @Provides
    @FeatureScope
    fun provideUserInteractor(userInteractor: UsersInteractorImpl): UserInteractor = userInteractor

    @Provides
    @FeatureScope
    fun provideUserApi(apiCreator: NetworkApiCreator): UserApi {
        return UserApiImpl()
    }
}