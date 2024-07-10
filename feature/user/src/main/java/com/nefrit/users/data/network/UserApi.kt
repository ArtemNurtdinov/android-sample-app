package com.nefrit.users.data.network

import com.nefrit.users.data.network.model.UserDTO

interface UserApi {

    suspend fun getUsers(): List<UserDTO>

    suspend fun getUser(id: Long): UserDTO
}