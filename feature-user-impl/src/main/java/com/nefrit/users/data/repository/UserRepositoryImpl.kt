package com.nefrit.users.data.repository

import com.nefrit.core_db.AppDatabase
import com.nefrit.core_db.dao.UserDao
import com.nefrit.feature_user_api.domain.interfaces.UserRepository
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.data.mappers.mapUserLocalToUser
import com.nefrit.users.data.mappers.mapUserRemoteToUser
import com.nefrit.users.data.mappers.mapUserToUserLocal
import com.nefrit.users.data.network.UserApi
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApi,
    private val db: AppDatabase
) : UserRepository {

    override fun getUser(id: Int): Observable<User> {
        return Single.concat(getLocalUser(id), getRemoteUser(id))
            .toObservable()
    }

    private fun getLocalUser(id: Int): Single<User> {
        return db.userDao().getUser(id)
            .map { mapUserLocalToUser(it) }
    }

    private fun getRemoteUser(id: Int): Single<User> {
        return api.getUser(id)
            .map { mapUserRemoteToUser(it) }
            .doOnSuccess { db.userDao().insert(mapUserToUserLocal(it)) }
    }

    override fun getUsers(): Observable<List<User>> {
        return Single.concat(getLocalUsers(), getRemoteUsers())
            .toObservable()
    }

    private fun getLocalUsers(): Single<List<User>> {
        return db.userDao().getUsers()
            .map { it.map { mapUserLocalToUser(it) } }
    }

    private fun getRemoteUsers(): Single<List<User>> {
        return api.getUsers()
            .map { it.map { mapUserRemoteToUser(it) } }
            .doOnSuccess { db.userDao().insert(it.map { mapUserToUserLocal(it) }) }
    }
}