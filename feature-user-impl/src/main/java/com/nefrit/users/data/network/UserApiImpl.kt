package com.nefrit.users.data.network

import com.nefrit.users.data.network.model.UserDTO
import io.reactivex.Single
import javax.inject.Inject

class UserApiImpl @Inject constructor() : UserApi {

    override fun getUsers(): Single<List<UserDTO>> {
        return Single.just(mockUsers())
    }

    override fun getUser(id: Long): Single<UserDTO> {
        return Single.fromCallable {
            mockUsers().firstOrNull { it.id == id } ?: throw RuntimeException("")
        }
    }

    private fun mockUsers(): List<UserDTO> {
        return mutableListOf<UserDTO>().apply {
            add(UserDTO(1, "Василий", "Васильев", "vas@gmail.com"))
            add(UserDTO(2, "Петр", "Петров", "petr1234@gmail.com"))
            add(UserDTO(3, "Александр", "Иванов", "alex_alex01@gmail.com"))
            add(UserDTO(4, "Ксения", "Васильева", "1fKsen@gmail.com"))
            add(UserDTO(5, "Надежда", "Миронова", null))
            add(UserDTO(6, "Ярослав", "Козлов", "slava_J@gmail.com"))
            add(UserDTO(7, "Динара", "Сафина", "safina1221@gmail.com"))
            add(UserDTO(8, "Михаил", "Облаков", "michaelS9@gmail.com"))
            add(UserDTO(9,"Светлана", "Зарипова", "parfsvetlana@gmail.com"))
            add(UserDTO(10, "Юлия", "Косякова", "julia99@gmail.com"))
            add(UserDTO(11, "Андрей", "Зайцев", null))

        }
    }
}