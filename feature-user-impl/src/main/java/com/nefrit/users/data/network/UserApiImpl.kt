package com.nefrit.users.data.network

import com.nefrit.users.data.network.model.UserRemote
import io.reactivex.Single
import javax.inject.Inject

class UserApiImpl @Inject constructor() : UserApi {

    override fun getUsers(): Single<List<UserRemote>> {
        return Single.just(mockUsers())
    }

    override fun getUser(id: Int): Single<UserRemote> {
        return Single.fromCallable {
            mockUsers().firstOrNull { it.id == id } ?: throw RuntimeException("")
        }
    }

    private fun mockUsers(): List<UserRemote> {
        return mutableListOf<UserRemote>().apply {
            add(UserRemote(1, "Василий", "Васильев"))
            add(UserRemote(2, "Петр", "Петров"))
            add(UserRemote(3, "Александр", "Иванов"))
            add(UserRemote(4, "Ксения", "Васильева"))
            add(UserRemote(5, "Надежда", "Миронова"))
            add(UserRemote(6, "Ярослав", "Козлов"))
            add(UserRemote(7, "Динара", "Сафина"))
            add(UserRemote(8, "Михаил", "Облаков"))
            add(UserRemote(9,"Светлана", "Зарипова"))
            add(UserRemote(10, "Юлия", "Косякова"))
            add(UserRemote(11, "Андрей", "Зайцев"))

        }
    }
}