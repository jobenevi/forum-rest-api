package com.api.forum.rest.api.service

import com.api.forum.rest.api.controller.request.TopicFormRequest
import com.api.forum.rest.api.controller.request.TopicUpdateFormRequest
import com.api.forum.rest.api.controller.response.TopicViewResponse
import com.api.forum.rest.api.exception.NotFoundException
import com.api.forum.rest.api.mapper.TopicFormMapper
import com.api.forum.rest.api.mapper.TopicViewMapper
import com.api.forum.rest.api.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = ArrayList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper,
    private val notFoundMessage: String = "Topic not found"
) {

    fun getTopicList(): List<TopicViewResponse> {
        return topics.stream().map { t ->
            topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun getTopicById(id: Long): TopicViewResponse {
        val topic = findTopicById(id)
        return topicViewMapper.map(topic)
    }

    fun createTopic(request: TopicFormRequest): TopicViewResponse {
        val topic = topicFormMapper.map(request)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopicById(request: TopicUpdateFormRequest): TopicViewResponse {
        val topic = findTopicById(request.id)

        val topicUpdated = Topic(
            id = request.id,
            title = request.title,
            message = request.message,
            user = topic.user,
            course = topic.course,
            answers = topic.answers,
            dateCreated = topic.dateCreated
        )

        topics = topics.minus(topic).plus(topicUpdated)

        return topicViewMapper.map(topicUpdated)
    }

    fun deleteTopicById(id: Long) {
        val topic = findTopicById(id)
        topics = topics.minus(topic)
    }

    private fun findTopicById(id: Long): Topic {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow { NotFoundException(notFoundMessage) }
        return topic
    }

}