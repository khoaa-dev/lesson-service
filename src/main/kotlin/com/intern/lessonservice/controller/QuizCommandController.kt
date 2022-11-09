package com.intern.lessonservice.controller


import com.intern.lessonservice.cqrs.command.domain.Quiz
import com.intern.lessonservice.cqrs.command.services.QuizService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class QuizCommandController(val quizService: QuizService) {
    @PostMapping("/addQuiz")
    fun addQuiz(@Valid @RequestBody quiz: Quiz): Quiz {
        return quizService.saveQuizDetails(quiz)
    }

    @PutMapping("/updateQuiz")
    fun updateQuiz(@Valid @RequestBody quiz: Quiz): Quiz {
        return quizService.updateQuizDetails(quiz)
    }

    @DeleteMapping("/deleteQuiz/quizId={quizId}")
    fun deleteQuiz(@PathVariable(value = "quizId") quizId: String): List<String> {
        return quizService.deleteQuiz(quizId)
    }


}