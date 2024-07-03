package com.nefrit.users.domain

import com.nefrit.users.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserRepository {

    fun observeUser(id: Long): Observable<User>

    fun observeUsers(): Observable<List<User>>

    fun updateUser(id: Long): Completable

    fun updateUsers(): Completable
}