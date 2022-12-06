package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.domain.Question
import com.intern.lessonservice.cqrs.repositories.QuestionRepository
import org.springframework.stereotype.Service

@Service
class QuestionQueryService(private val questionRepository: QuestionRepository) {
    fun getQuestionByIdQuiz(id_quiz: Long): MutableList<Question> {
        return questionRepository.findByQuizId(id_quiz)
    }
}