package com.nefrit.users.domain

import com.nefrit.core.interfaces.UserRepository
import com.nefrit.model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getUsers(): Single<List<User>> {
        return userRepository.getUses()
            .subscribeOn(Schedulers.io())
    }
}