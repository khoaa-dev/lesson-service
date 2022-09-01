package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.query.domain.Lesson
import com.intern.lessonservice.cqrs.query.services.LessonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class LessonQueryController (val lessonService: LessonService){
    @GetMapping("/lessons")
    //fun getAllLessons(): List<Lesson> = lessonService.findAll()
    fun getAllLessons() = ResponseEntity(lessonService.findAll(), HttpStatus.OK)

    @GetMapping("lessons/{id}")
    fun getLessonById(
        @PathVariable(value = "id") lessonId: Long
    ): ResponseEntity<Lesson> {
        return lessonService.findById(lessonId)
    }
}