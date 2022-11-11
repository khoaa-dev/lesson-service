package com.intern.lessonservice.controller


import com.intern.lessonservice.cqrs.command.domain.Question
import com.intern.lessonservice.cqrs.command.services.QuestionService
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
class QuestionCommandController(val questionService: QuestionService) {
    @PostMapping("/addQuestion")
    fun addQuestion(@Valid @RequestBody question: Question): Question {
        return questionService.saveQuestionDetails(question)
    }

    @PutMapping("/updateQuestion")
    fun updateQuestion(@Valid @RequestBody question: Question): Question {
        return questionService.updateQuestionDetails(question)
    }

    @DeleteMapping("/deleteQuestion/questionId={questionId}")
    fun deleteQuestion(@PathVariable(value = "questionId") questionId: String): List<String> {
        return questionService.deleteQuestion(questionId)
    }


}