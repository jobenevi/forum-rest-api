package com.api.forum.rest.api.controller.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicFormRequest(
    @field:NotEmpty(message = "Title is required")
    @field:Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    val title: String,
    @field:NotEmpty(message = "Message is required")
    val message: String,
    @field:NotNull
    val courseId: Long,
    @field:NotNull
    val userId: Long
)