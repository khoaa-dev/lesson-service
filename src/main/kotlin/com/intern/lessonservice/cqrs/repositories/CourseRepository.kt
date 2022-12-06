package com.intern.lessonservice.cqrs.repositories

import com.intern.lessonservice.cqrs.domain.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course, Long> {
    fun findByIdTeacher(id_teacher: Long): MutableList<Course>

    fun findByIdStudent(id_student: Long): MutableList<Course>
}