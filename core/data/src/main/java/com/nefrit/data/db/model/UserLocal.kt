package com.nefrit.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserLocal(
    @PrimaryKey val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String?
)