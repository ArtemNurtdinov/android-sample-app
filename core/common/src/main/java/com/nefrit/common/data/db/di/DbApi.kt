package com.nefrit.common.data.db.di

import com.nefrit.common.data.db.AppDatabase

interface DbApi {

    fun provideDatabase(): AppDatabase
}