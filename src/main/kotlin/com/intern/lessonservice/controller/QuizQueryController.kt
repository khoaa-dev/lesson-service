package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.command.domain.Quiz
import com.intern.lessonservice.cqrs.command.services.QuizService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuizQueryController(val quizService: QuizService) {
    @GetMapping("/quiz/lessonId={lessonId}")
    fun getAllQuiz(@PathVariable(value = "lessonId") lessonId: Long): MutableList<Quiz> {
        return quizService.getQuizByLessonId(lessonId)
    }
}