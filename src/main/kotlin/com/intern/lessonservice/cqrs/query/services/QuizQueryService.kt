package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.domain.Quiz
import com.intern.lessonservice.cqrs.repositories.QuizRepository
import org.springframework.stereotype.Service

@Service
class QuizQueryService(private val quizInfoRepository: QuizRepository) {
    fun getQuizByIdLesson(id_lesson: Long): MutableList<Quiz> {
        return quizInfoRepository.findByLessonId(id_lesson)
    }
}