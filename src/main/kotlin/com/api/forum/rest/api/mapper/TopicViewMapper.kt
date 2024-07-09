package com.api.forum.rest.api.mapper

import com.api.forum.rest.api.controller.response.TopicViewResponse
import com.api.forum.rest.api.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicViewResponse> {
    override fun map(t: Topic): TopicViewResponse {
        return TopicViewResponse(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            dateCreated = t.dateCreated
        )
    }

}