package com.nefrit.core_db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserLocal(
    @PrimaryKey val id: Int,
    val firstName: String,
    val lastName: String
)