package com.nefrit.data.di

import com.nefrit.core.di.ApplicationScope
import com.nefrit.core.interfaces.UserRepository
import com.nefrit.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    @ApplicationScope
    fun bindUserRepository(userRepository: UserRepositoryImpl): UserRepository
}