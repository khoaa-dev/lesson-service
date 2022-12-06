package com.intern.lessonservice.cqrs.repositories

import com.intern.lessonservice.cqrs.domain.Lesson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonRepository : JpaRepository<Lesson, Long> {
    fun findByCourseId(id_course: Long?): MutableList<Lesson>

    fun findByCourseIdAndTimeStartIgnoreCaseContaining(id_course: Long?, time_start: String): MutableList<Lesson>
}