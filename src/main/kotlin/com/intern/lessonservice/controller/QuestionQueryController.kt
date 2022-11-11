package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.command.domain.Question
import com.intern.lessonservice.cqrs.command.services.QuestionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class QuestionQueryController(val questionService: QuestionService) {
    @GetMapping("/question/quizId={quizId}")
    fun getQuestionByQuizId(@PathVariable(value = "quizId") quizId: Long): MutableList<Question> {
        return questionService.getQuestionByQuizId(quizId)
    }
}