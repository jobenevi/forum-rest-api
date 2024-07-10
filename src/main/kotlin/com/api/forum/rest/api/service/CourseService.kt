package com.api.forum.rest.api.service

import com.api.forum.rest.api.model.Course
import com.api.forum.rest.api.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
    private val repository: CourseRepository) {

    fun findCourseById(id: Long): Course {
        return repository.findById(id).get()
    }

}
