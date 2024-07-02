package com.nefrit.users.data

import com.nefrit.common.data.db.AppDatabase
import com.nefrit.feature_user_api.domain.interfaces.UserRepository
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.data.mappers.UserMappers
import com.nefrit.users.data.network.UserApi
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val db: AppDatabase,
    private val userMappers: UserMappers,
) : UserRepository {

    override fun observeUser(id: Long): Observable<User> {
        return db.userDao().getUser(id)
            .map(userMappers::mapUserLocalToUser)
    }

    override fun observeUsers(): Observable<List<User>> {
        return db.userDao().getUsers()
            .map(userMappers::mapUserLocalList)
    }

    override fun updateUser(id: Long): Completable {
        return api.getUser(id)
            .map(userMappers::mapUserRemoteToUser)
            .doOnSuccess(::saveUserInDb)
            .ignoreElement()
    }

    override fun updateUsers(): Completable {
        return api.getUsers()
            .map(userMappers::mapUserRemoteList)
            .doOnSuccess(::saveUsersInDb)
            .ignoreElement()
    }

    private fun saveUsersInDb(users: List<User>) {
        db.userDao().insert(users.map(userMappers::mapUserToUserLocal))
    }

    private fun saveUserInDb(user: User) {
        db.userDao().insert(userMappers.mapUserToUserLocal(user))
    }
}