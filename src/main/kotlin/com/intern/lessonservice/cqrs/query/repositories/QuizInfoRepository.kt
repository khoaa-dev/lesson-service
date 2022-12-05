package com.intern.lessonservice.cqrs.query.repositories

import com.intern.lessonservice.cqrs.query.domain.QuizInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface QuizInfoRepository : JpaRepository<QuizInfo, Long> {
//    @Query("SELECT * FROM quiz WHERE id_lesson = %:id_lesson%")
    fun findByIdLesson(id_lesson: Long): MutableList<QuizInfo>
}