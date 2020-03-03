package com.nefrit.core.interfaces

import com.nefrit.model.User
import io.reactivex.Observable

interface UserRepository {

    fun getUser(id: Int): Observable<User>

    fun getUsers(): Observable<List<User>>
}