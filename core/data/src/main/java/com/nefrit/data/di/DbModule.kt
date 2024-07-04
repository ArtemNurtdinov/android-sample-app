package com.nefrit.data.di

import android.content.Context
import com.nefrit.data.db.AppDatabase
import com.nefrit.common.di.ApplicationScope
import com.nefrit.data.db.dao.UserDao
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.get(context)
    }

    @Provides
    @ApplicationScope
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}