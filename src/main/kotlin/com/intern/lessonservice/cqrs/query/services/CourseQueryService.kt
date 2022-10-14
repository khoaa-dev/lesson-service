package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.command.repositories.CourseRepository
import com.intern.lessonservice.cqrs.query.domain.CourseInfo
import com.intern.lessonservice.cqrs.query.repositories.CourseInfoRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseQueryService(val courseInfoRepository: CourseInfoRepository) {
    fun findByCourseId(id: Long): ResponseEntity<CourseInfo> {
        return courseInfoRepository.findById(id).map { courseInfo ->
            ResponseEntity.ok(courseInfo)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun findByTeacherId(id_teacher: Long): MutableList<CourseInfo> {
        return courseInfoRepository.findCourseByIdTeacher(id_teacher)
    }
}