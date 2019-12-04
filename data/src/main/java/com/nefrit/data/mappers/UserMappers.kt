package com.nefrit.data.mappers

import com.nefrit.data.db.model.UserLocal
import com.nefrit.data.network.model.UserRemote
import com.nefrit.model.User

fun mapUserToUserLocal(user: User): UserLocal {
    return with(user) {
        UserLocal(id, firstName, lastName)
    }
}

fun mapUserLocalToUser(user: UserLocal): User {
    return with(user) {
        User(id, firstName, lastName)
    }
}

fun mapUserRemoteToUser(user: UserRemote): User {
    return with(user) {
        User(id, firstName, lastName)
    }
}