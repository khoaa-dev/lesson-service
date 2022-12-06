package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.domain.Course
import com.intern.lessonservice.cqrs.repositories.CourseRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CourseQueryService(val courseRepository: CourseRepository) {
    fun findByCourseId(id: Long): ResponseEntity<Course>? {
        return courseRepository.findById(id).map { courseInfo ->
            ResponseEntity.ok(courseInfo)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun findByTeacherId(id_teacher: Long): MutableList<Course> {
        return courseRepository.findByIdTeacher(id_teacher)
    }
}