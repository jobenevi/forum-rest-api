package com.api.forum.rest.api.repository

import com.api.forum.rest.api.model.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
}