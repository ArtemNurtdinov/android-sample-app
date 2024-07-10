package com.nefrit.users.data

import com.nefrit.data.db.AppDatabase
import com.nefrit.users.data.mappers.UserMappers
import com.nefrit.users.data.network.UserApi
import com.nefrit.users.domain.UserRepository
import com.nefrit.users.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val db: AppDatabase,
    private val userMappers: UserMappers,
) : UserRepository {

    override fun observeUser(id: Long): Flow<User> {
        return db.userDao().getUser(id)
            .map(userMappers::mapUserLocalToUser)
    }

    override fun observeUsers(): Flow<List<User>> {
        return db.userDao().getUsers()
            .map(userMappers::mapUserLocalList)
    }

    override suspend fun updateUser(id: Long) {
        val userDto = api.getUser(id)
        val user = userMappers.mapUserRemoteToUser(userDto)
        saveUserInDb(user)
    }

    override suspend fun updateUsers() {
        val users = api.getUsers().map(userMappers::mapUserRemoteToUser)
        saveUsersInDb(users)
    }

    private fun saveUsersInDb(users: List<User>) {
        db.userDao().insert(users.map(userMappers::mapUserToUserLocal))
    }

    private fun saveUserInDb(user: User) {
        db.userDao().insert(userMappers.mapUserToUserLocal(user))
    }
}