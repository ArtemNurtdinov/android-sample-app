package com.nefrit.users.data.mappers

import com.nefrit.common.data.db.model.UserLocal
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.data.network.model.UserRemote
import javax.inject.Inject

class UserMappers @Inject constructor() {

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

    fun mapUserLocalList(list: List<UserLocal>): List<User> {
        return list.map(::mapUserLocalToUser)
    }

    fun mapUserRemoteList(list: List<UserRemote>): List<User> {
        return list.map(::mapUserRemoteToUser)
    }
}