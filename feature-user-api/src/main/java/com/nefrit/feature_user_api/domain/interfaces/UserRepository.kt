package com.nefrit.feature_user_api.domain.interfaces

import com.nefrit.feature_user_api.domain.model.User
import io.reactivex.Observable

interface UserRepository {

    fun getUser(id: Int): Observable<User>

    fun getUsers(): Observable<List<User>>
}