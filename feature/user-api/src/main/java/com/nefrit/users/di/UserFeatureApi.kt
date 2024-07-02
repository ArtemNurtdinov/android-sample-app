package com.nefrit.users.di

import com.nefrit.users.domain.interfaces.UserInteractor
import com.nefrit.users.domain.interfaces.UserRepository

interface UserFeatureApi {

    fun provideUserRepository(): UserRepository

    fun provideUserInteractor(): UserInteractor
}