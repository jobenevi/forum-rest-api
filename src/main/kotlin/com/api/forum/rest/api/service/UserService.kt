package com.api.forum.rest.api.service

import com.api.forum.rest.api.model.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "John Doe",
            email = "john.doe@email.com"
        )
        users = Arrays.asList(user)
    }

    fun findUserById(id: Long): User {
        return users.stream().filter { u ->
            u.id == id
        }.findFirst().get()
    }

}
