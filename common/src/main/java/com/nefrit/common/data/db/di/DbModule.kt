package com.nefrit.common.data.db.di

import android.content.Context
import com.nefrit.common.data.db.AppDatabase
import com.nefrit.common.data.db.dao.UserDao
import com.nefrit.common.di.scope.ApplicationScope
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