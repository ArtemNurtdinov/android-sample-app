package com.nefrit.users.domain

import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.interfaces.UserRepository
import com.nefrit.feature_user_api.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class UsersInteractorImpl @Inject constructor(
    private val userRepository: UserRepository
) : UserInteractor {

    override fun observeUsers(): Observable<List<User>> {
        return userRepository.observeUsers()
    }

    override fun updateUsers(): Completable {
        return userRepository.updateUsers()
    }

    override fun updateUser(id: Int): Completable {
        return userRepository.updateUser(id)
    }

    override fun observeUser(id: Int): Observable<User> {
        return userRepository.observeUser(id)
    }
}