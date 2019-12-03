package com.nefrit.user.di

import com.nefrit.core.di.ComponentDependencies
import com.nefrit.core.interfaces.UserRepository

interface UserDependencies : ComponentDependencies {

    fun provideUserRepository(): UserRepository
}