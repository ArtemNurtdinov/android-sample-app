package com.nefrit.users.data.network

import com.nefrit.users.data.network.model.UserRemote
import io.reactivex.Single

interface UserApi {

    fun getUsers(): Single<List<UserRemote>>

    fun getUser(id: Int): Single<UserRemote>
}