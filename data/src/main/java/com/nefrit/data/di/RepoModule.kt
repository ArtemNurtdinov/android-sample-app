package com.nefrit.data.di

import com.nefrit.core.interfaces.UserRepository
import com.nefrit.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import jp.co.soramitsu.core_di.scope.ApplicationScope

@Module
interface RepoModule {

    @Binds
    @ApplicationScope
    fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}