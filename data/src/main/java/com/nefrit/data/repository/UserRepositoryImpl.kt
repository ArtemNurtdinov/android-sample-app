package com.nefrit.data.repository

import com.nefrit.core.interfaces.UserRepository
import com.nefrit.model.User
import io.reactivex.Single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(

) : UserRepository {

    override fun getUser(id: Int): Single<User> {
        return Single.fromCallable {
            mockUsers().firstOrNull { it.id == id } ?: throw RuntimeException("")
        }
    }

    override fun getUses(): Single<List<User>> {
        return Single.just(mockUsers())
    }

    private fun mockUsers(): List<User> {
        return mutableListOf<User>().apply {
            add(User(1, "Василий", "Пупкин"))
            add(User(2, "Петр", "Петров"))
            add(User(3, "Александр", "Иванов"))
        }
    }
}