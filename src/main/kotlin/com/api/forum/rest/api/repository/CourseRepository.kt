package com.api.forum.rest.api.repository

import com.api.forum.rest.api.model.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository: JpaRepository<Course, Long> {
}