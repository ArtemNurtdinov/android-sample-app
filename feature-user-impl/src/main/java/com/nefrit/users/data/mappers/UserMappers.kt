package com.nefrit.users.data.mappers

import com.nefrit.common.data.db.model.UserLocal
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.data.network.model.UserDTO
import javax.inject.Inject

class UserMappers @Inject constructor() {

    fun mapUserToUserLocal(user: User): UserLocal {
        return with(user) {
            UserLocal(id, firstName, lastName, email)
        }
    }

    fun mapUserLocalToUser(user: UserLocal): User {
        return with(user) {
            User(id, firstName, lastName, email)
        }
    }

    fun mapUserRemoteToUser(user: UserDTO): User {
        return with(user) {
            User(id, firstName, lastName, email)
        }
    }

    fun mapUserLocalList(list: List<UserLocal>): List<User> {
        return list.map(::mapUserLocalToUser)
    }

    fun mapUserRemoteList(list: List<UserDTO>): List<User> {
        return list.map(::mapUserRemoteToUser)
    }
}