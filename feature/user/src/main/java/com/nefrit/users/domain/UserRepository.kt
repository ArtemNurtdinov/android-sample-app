package com.nefrit.users.domain

import com.nefrit.users.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun observeUser(id: Long): Flow<User>

    fun observeUsers(): Flow<List<User>>

    suspend fun updateUser(id: Long)

    suspend fun updateUsers()
}