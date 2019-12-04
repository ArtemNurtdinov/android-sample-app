package com.nefrit.data.di

import com.nefrit.core.di.ApplicationScope
import com.nefrit.data.network.UserApi
import com.nefrit.data.network.UserApiImpl
import dagger.Binds
import dagger.Module

@Module
interface ApiModule {

    @ApplicationScope
    @Binds
    fun bindUserApi(userApi: UserApiImpl): UserApi
}