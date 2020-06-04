package com.nefrit.users.di

import com.nefrit.core_db.AppDatabase
import com.nefrit.core_db.dao.UserDao
import com.nefrit.network.NetworkApiCreator

interface UserFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun db(): AppDatabase
}