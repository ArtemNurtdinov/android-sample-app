package com.nefrit.users.data.network.model

data class UserDTO(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String?
)