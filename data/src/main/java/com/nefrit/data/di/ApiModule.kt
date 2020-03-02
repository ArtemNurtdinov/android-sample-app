package com.nefrit.data.di

import com.nefrit.data.network.UserApi
import com.nefrit.data.network.UserApiImpl
import dagger.Binds
import dagger.Module
import jp.co.soramitsu.core_di.scope.ApplicationScope

@Module
interface ApiModule {

    @ApplicationScope
    @Binds
    fun bindUserApi(userApi: UserApiImpl): UserApi
}