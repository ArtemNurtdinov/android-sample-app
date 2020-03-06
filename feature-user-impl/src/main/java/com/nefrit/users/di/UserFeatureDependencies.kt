package com.nefrit.users.di

import com.nefrit.core_db.dao.UserDao
import com.nefrit.core_network_api.NetworkApiCreator

interface UserFeatureDependencies {

    fun networkApiCreator(): NetworkApiCreator

    fun userDao(): UserDao
}