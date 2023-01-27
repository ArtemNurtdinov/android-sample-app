package com.nefrit.feature_user_api.domain.interfaces

import com.nefrit.feature_user_api.domain.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface UserInteractor {

    fun observeUser(id: Int): Observable<User>

    fun updateUser(id: Int): Completable

    fun observeUsers(): Observable<List<User>>

    fun updateUsers(): Completable
}