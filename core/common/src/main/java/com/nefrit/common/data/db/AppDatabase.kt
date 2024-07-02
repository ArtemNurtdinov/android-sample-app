package com.nefrit.common.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nefrit.common.data.db.dao.UserDao
import com.nefrit.common.data.db.model.UserLocal

private const val DATABASE_NAME = "app.db"

@Database(
    version = 1,
    entities = [
        UserLocal::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    companion object {

        fun get(context: Context): AppDatabase = Room
            .databaseBuilder(context.applicationContext, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    abstract fun userDao(): UserDao
}