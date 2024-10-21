package com.api.forum.rest.api.mapper

import com.api.forum.rest.api.controller.request.TopicFormRequest
import com.api.forum.rest.api.model.Topic
import com.api.forum.rest.api.service.CourseService
import com.api.forum.rest.api.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
) : Mapper<TopicFormRequest, Topic> {
    override fun map(t: TopicFormRequest): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.findCourseById(t.courseId),
            userForum = userService.findUserById(t.userId)
        )
    }

}
