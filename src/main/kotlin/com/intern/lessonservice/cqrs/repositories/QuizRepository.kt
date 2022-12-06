package com.intern.lessonservice.cqrs.repositories

import com.intern.lessonservice.cqrs.domain.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuizRepository : JpaRepository<Quiz, Long> {
    fun findByLessonId(id_lesson: Long): MutableList<Quiz>
}