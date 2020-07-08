package com.nefrit.users.di

import com.nefrit.common.data.network.NetworkApiCreator
import com.nefrit.core_db.AppDatabase

interface UserFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun db(): AppDatabase
}