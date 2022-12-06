package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.domain.Quiz
import com.intern.lessonservice.cqrs.query.services.QuizQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuizQueryController(private val quizQueryService: QuizQueryService) {
    @GetMapping("/quiz/id_lesson={id_lesson}")
    fun getQuizByIdLesson(@PathVariable(value = "id_lesson") id_lesson: Long): MutableList<Quiz> {
        return quizQueryService.getQuizByIdLesson(id_lesson)
    }
}