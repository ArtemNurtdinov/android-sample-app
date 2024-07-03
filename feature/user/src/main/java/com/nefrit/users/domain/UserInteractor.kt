package com.nefrit.users.domain

import com.nefrit.users.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

class UserInteractor(
    private val userRepository: UserRepository
) {

    fun observeUsers(): Observable<List<User>> {
        return userRepository.observeUsers()
    }

    fun updateUsers(): Completable {
        return userRepository.updateUsers()
    }

    fun updateUser(id: Long): Completable {
        return userRepository.updateUser(id)
    }

    fun observeUser(id: Long): Observable<User> {
        return userRepository.observeUser(id)
    }
}