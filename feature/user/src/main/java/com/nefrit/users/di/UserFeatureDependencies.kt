package com.nefrit.users.di

import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.common.data.db.AppDatabase

interface UserFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun db(): AppDatabase

    fun resourceManager(): ResourceManager
}