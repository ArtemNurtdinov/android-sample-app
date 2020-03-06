package com.nefrit.core_db.di

import com.nefrit.core_db.AppDatabase
import com.nefrit.core_db.dao.UserDao

interface DbApi {

    fun provideDatabase(): AppDatabase

    fun provideUserDao(): UserDao
}