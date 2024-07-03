package com.nefrit.users.di

import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.UserRepository

interface UserFeatureApi {

    fun provideUserRepository(): UserRepository

    fun provideUserInteractor(): UserInteractor
}