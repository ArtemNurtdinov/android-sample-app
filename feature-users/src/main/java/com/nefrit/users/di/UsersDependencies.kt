package com.nefrit.users.di

import com.nefrit.core.di.ComponentDependencies
import com.nefrit.core.interfaces.UserRepository
import com.nefrit.users.domain.UsersRouter

interface UsersDependencies : ComponentDependencies {

    fun provideRouter(): UsersRouter

    fun provideUserRepository(): UserRepository
}