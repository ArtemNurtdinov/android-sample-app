package com.nefrit.users.di

import com.nefrit.core.interfaces.UserRepository
import com.nefrit.users.domain.UsersRouter

interface UsersDependencies : jp.co.soramitsu.core_di.ComponentDependencies {

    fun provideRouter(): UsersRouter

    fun provideUserRepository(): UserRepository
}