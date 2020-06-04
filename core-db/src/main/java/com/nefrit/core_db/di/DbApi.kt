package com.nefrit.core_db.di

import com.nefrit.core_db.AppDatabase

interface DbApi {

    fun provideDatabase(): AppDatabase
}