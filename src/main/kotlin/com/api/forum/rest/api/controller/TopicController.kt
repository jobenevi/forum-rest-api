package com.api.forum.rest.api.controller

import com.api.forum.rest.api.controller.request.TopicFormRequest
import com.api.forum.rest.api.controller.request.TopicUpdateFormRequest
import com.api.forum.rest.api.controller.response.TopicViewResponse
import com.api.forum.rest.api.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")
class TopicController(private val service: TopicService) {

    @GetMapping
    fun getAllTopics(): List<TopicViewResponse> {
        return service.getTopicList()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicViewResponse {
        return service.getTopicById(id)
    }

    @PostMapping
    @Transactional
    fun createTopic(
        @RequestBody @Valid request: TopicFormRequest,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicViewResponse> {
        val topicViewResponse = service.createTopic(request)
        val uri = uriBuilder.path("/topics/${topicViewResponse.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicViewResponse)
    }

    @PutMapping()
    @Transactional
    fun updateTopic(@RequestBody @Valid request: TopicUpdateFormRequest): ResponseEntity<TopicViewResponse> {
        val topicViewResponse = service.updateTopicById(request)
        return ResponseEntity.ok(topicViewResponse)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopicById(id)
    }

}