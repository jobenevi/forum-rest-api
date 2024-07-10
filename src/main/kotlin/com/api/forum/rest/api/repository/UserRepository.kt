package com.api.forum.rest.api.repository

import com.api.forum.rest.api.model.UserForum
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserForum, Long> {
}