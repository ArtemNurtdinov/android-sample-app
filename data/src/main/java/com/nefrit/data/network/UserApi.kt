package com.nefrit.data.network

import com.nefrit.data.network.model.UserRemote
import io.reactivex.Single

interface UserApi {

    fun getUsers(): Single<List<UserRemote>>

    fun getUser(id: Int): Single<UserRemote>
}