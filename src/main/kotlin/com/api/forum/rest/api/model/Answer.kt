package com.api.forum.rest.api.model

import java.time.LocalDateTime

data class Answer (
    val id: Long? = null,
    val message: String,
    val dateCreated: LocalDateTime = LocalDateTime.now(),
    val user: User,
    val topic: Topic,
    val solution: Boolean
)
