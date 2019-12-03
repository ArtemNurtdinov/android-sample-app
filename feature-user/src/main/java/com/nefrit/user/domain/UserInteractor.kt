package com.nefrit.user.domain

import com.nefrit.core.interfaces.UserRepository
import com.nefrit.model.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserInteractor @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getUser(id: Int): Single<User> {
        return userRepository.getUser(id)
            .subscribeOn(Schedulers.io())
    }
}