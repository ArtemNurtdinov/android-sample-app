package com.nefrit.users.data.network

import com.nefrit.users.data.network.model.UserDTO
import io.reactivex.Single

interface UserApi {

    fun getUsers(): Single<List<UserDTO>>

    fun getUser(id: Long): Single<UserDTO>
}