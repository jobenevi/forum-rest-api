package com.api.forum.rest.api.service

import com.api.forum.rest.api.controller.request.TopicFormRequest
import com.api.forum.rest.api.controller.request.TopicUpdateFormRequest
import com.api.forum.rest.api.controller.response.TopicViewResponse
import com.api.forum.rest.api.exception.NotFoundException
import com.api.forum.rest.api.mapper.TopicFormMapper
import com.api.forum.rest.api.mapper.TopicViewMapper
import com.api.forum.rest.api.model.Topic
import com.api.forum.rest.api.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private val repository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun getTopicList(): List<TopicViewResponse> {
        return repository.findAll().stream()
            .map { topicViewMapper.map(it) }
            .collect(Collectors.toList())
    }

    fun getTopicById(id: Long): TopicViewResponse {
        val topic = findTopicById(id)
        return topicViewMapper.map(topic)
    }

    fun createTopic(request: TopicFormRequest): TopicViewResponse {
        val topic = topicFormMapper.map(request)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopicById(request: TopicUpdateFormRequest): TopicViewResponse {
        val topic = findTopicById(request.id)

        topic.title = request.title
        topic.message = request.message

        return topicViewMapper.map(topic)
    }

    fun deleteTopicById(id: Long) {
        repository.deleteById(id)
    }

    private fun findTopicById(id: Long): Topic {
        val topic = repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
        return topic
    }

}