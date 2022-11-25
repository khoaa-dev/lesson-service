package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.command.domain.Course
import com.intern.lessonservice.cqrs.command.domain.Quiz
import com.intern.lessonservice.cqrs.command.repositories.QuizRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class QuizService(private val quizRepository: QuizRepository) {
    fun addQuiz(quiz: Quiz) : Quiz = quizRepository.save(quiz)

    fun updateQuiz(idQuiz : Long, quiz: Quiz) : ResponseEntity<Quiz> {
        return quizRepository.findById(idQuiz).map { existingQuiz ->
            val updateQuiz: Quiz = existingQuiz
                .copy(title = quiz.title)
            ResponseEntity.ok().body(quizRepository.save(updateQuiz))
        }.orElse(ResponseEntity.notFound().build())
    }
}