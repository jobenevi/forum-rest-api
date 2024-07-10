package com.api.forum.rest.api.service

import com.api.forum.rest.api.model.UserForum
import com.api.forum.rest.api.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val repository: UserRepository
) {

    fun findUserById(id: Long): UserForum {
        return repository.findById(id).get()
    }

}
