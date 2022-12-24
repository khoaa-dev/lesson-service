package com.intern.lessonservice.controller


import com.intern.lessonservice.cqrs.domain.Question
import com.intern.lessonservice.cqrs.command.services.QuestionService
import org.springframework.http.ResponseEntity
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
        return questionService.addQuestion(question)
    }

    @PutMapping("/updateQuestion/{id_question}")
    fun updateQuestion(
        @PathVariable(value = "id_question") id_question: Long,
        @Valid @RequestBody question: Question
    ): ResponseEntity<Question> {
        return questionService.updateQuestionInfo(id_question, question)
    }

//    @DeleteMapping("/deleteQuestion/questionId={questionId}")
//    fun deleteQuestion(@PathVariable(value = "questionId") questionId: String): List<String> {
//        return questionService.deleteQuestion(questionId)
//    }


}