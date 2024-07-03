package com.nefrit.users.di

import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.di.scope.FeatureScope
import com.nefrit.users.data.network.UserApi
import com.nefrit.users.data.network.UserApiImpl
import com.nefrit.users.data.UserRepositoryImpl
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.UserRepository
import dagger.Module
import dagger.Provides

@Module
class UserFeatureModule {

    @Provides
    @FeatureScope
    fun provideUserRepository(userRepository: UserRepositoryImpl): UserRepository = userRepository

    @Provides
    @FeatureScope
    fun provideUserInteractor(repository: UserRepository): UserInteractor {
        return UserInteractor(repository)
    }

    @Provides
    @FeatureScope
    fun provideUserApi(apiCreator: NetworkApiCreator): UserApi {
        return UserApiImpl()
    }
}