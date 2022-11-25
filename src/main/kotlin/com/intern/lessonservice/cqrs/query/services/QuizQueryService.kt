package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.command.repositories.QuizRepository
import com.intern.lessonservice.cqrs.query.domain.QuizInfo
import com.intern.lessonservice.cqrs.query.repositories.QuizInfoRepository
import org.springframework.stereotype.Service

@Service
class QuizQueryService(private val quizInfoRepository: QuizInfoRepository) {
    fun getQuizByIdLesson(id_lesson: Long): MutableList<QuizInfo> {
        return quizInfoRepository.getQuizByIdLesson(id_lesson)
    }
}