package com.nefrit.users.domain

import com.nefrit.users.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import kotlinx.coroutines.flow.Flow

class UserInteractor(
    private val userRepository: UserRepository
) {

    fun observeUsers(): Flow<List<User>> {
        return userRepository.observeUsers()
    }

    suspend fun updateUsers() {
        return userRepository.updateUsers()
    }

    suspend fun updateUser(id: Long) {
        return userRepository.updateUser(id)
    }

    fun observeUser(id: Long): Flow<User> {
        return userRepository.observeUser(id)
    }
}