package com.nefrit.users.di

import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.di.scope.ApplicationScope
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
    @ApplicationScope
    fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository = userRepository

    @Provides
    @ApplicationScope
    fun provideUserInteractor(userInteractor: UsersInteractorImpl): UserInteractor = userInteractor

    @Provides
    @ApplicationScope
    fun provideUserApi(apiCreator: NetworkApiCreator): UserApi {
        return UserApiImpl()
    }
}