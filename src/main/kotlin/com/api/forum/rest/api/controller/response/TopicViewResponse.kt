package com.api.forum.rest.api.controller.response

import com.api.forum.rest.api.model.StatusTopic
import java.time.LocalDateTime

data class TopicViewResponse(
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val dateCreated: LocalDateTime
)
