package com.nefrit.core.interfaces

import com.nefrit.model.User
import io.reactivex.Single

interface UserRepository {

    fun getUser(id: Int): Single<User>

    fun getUses(): Single<List<User>>
}