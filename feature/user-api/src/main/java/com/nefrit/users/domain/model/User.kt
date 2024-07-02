package com.nefrit.users.domain.model

data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String?
)