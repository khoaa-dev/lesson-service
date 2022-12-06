package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.domain.Course
import com.intern.lessonservice.cqrs.domain.Quiz
import com.intern.lessonservice.cqrs.command.services.QuizService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class QuizCommandController(private val quizService: QuizService) {
    @PostMapping("/quiz")
    fun addCourse(@Valid @RequestBody quiz: Quiz): Quiz {
        return quizService.addQuiz(quiz)
    }

    @PutMapping("/updateQuiz/id_quiz={id_quiz}")
    fun updateIDStudent(
        @PathVariable(value = "id_quiz") id_quiz: Long,
        @Valid @RequestBody quiz: Quiz,
    ) : ResponseEntity<Quiz> {
        return quizService.updateQuiz(id_quiz, quiz)
    }
}