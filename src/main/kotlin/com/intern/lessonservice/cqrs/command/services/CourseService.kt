package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.domain.Course
import com.intern.lessonservice.cqrs.repositories.CourseRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CourseService(private val courseRepository: CourseRepository) {
    fun addCourse(course : Course): Course = courseRepository.save(course)

    fun updateCourseInfo(id_course: Long, course: Course): ResponseEntity<Course> {
        return courseRepository.findById(id_course).map { existingCourse ->
            val updateCourse: Course = existingCourse
                .copy(nameCourse = course.nameCourse,
                    idStudent = course.idStudent,
                    tutorFee = course.tutorFee)

            ResponseEntity.ok().body(courseRepository.save(updateCourse))
        }.orElse(ResponseEntity.notFound().build())
    }

}