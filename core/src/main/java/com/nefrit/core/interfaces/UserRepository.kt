package com.nefrit.core.interfaces

import com.nefrit.model.User
import io.reactivex.Observable
import io.reactivex.Single

interface UserRepository {

    fun getUser(id: Int): Observable<User>

    fun getUsers(): Observable<List<User>>
}