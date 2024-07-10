package com.nefrit.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nefrit.data.db.model.UserLocal
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao {

    @Query("select * from users")
    abstract fun getUsers(): Flow<List<UserLocal>>

    @Query("select * from users where id = :id")
    abstract fun getUser(id: Long): Flow<UserLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(users: List<UserLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(user: UserLocal): Long
}