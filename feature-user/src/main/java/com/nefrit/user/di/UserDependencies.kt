package com.nefrit.user.di

import com.nefrit.core.interfaces.UserRepository

interface UserDependencies : jp.co.soramitsu.core_di.ComponentDependencies {

    fun provideUserRepository(): UserRepository
}