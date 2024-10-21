package com.api.forum.rest.api.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
data class Answer (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val message: String,

    val dateCreated: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    val userForum: UserForum,

    @ManyToOne
    val topic: Topic,

    val solution: Boolean
)
