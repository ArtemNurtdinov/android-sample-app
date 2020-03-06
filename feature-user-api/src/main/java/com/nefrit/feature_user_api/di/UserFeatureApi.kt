package com.nefrit.feature_user_api.di

import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.interfaces.UserRepository

interface UserFeatureApi {

    fun provideUserRepository(): UserRepository

    fun provideUserInteractor(): UserInteractor
}