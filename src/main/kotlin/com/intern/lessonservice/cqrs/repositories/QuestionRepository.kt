package com.intern.lessonservice.cqrs.repositories

import com.intern.lessonservice.cqrs.domain.Question
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository : JpaRepository<Question, Long> {
    fun findByQuizId(id_quiz: Long): MutableList<Question>
}