package com.nefrit.users.di

import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.data.db.AppDatabase
import com.nefrit.users.presentation.UsersRouter

interface UserFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun db(): AppDatabase

    fun resourceManager(): ResourceManager

    fun usersRouter(): UsersRouter
}