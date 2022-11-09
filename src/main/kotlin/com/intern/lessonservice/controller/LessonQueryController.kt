package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.query.domain.LessonInfo
import com.intern.lessonservice.cqrs.query.services.LessonQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class LessonQueryController (val lessonQueryService: LessonQueryService){

    @GetMapping("/lessons/id_course={id}")
    fun getLessonById(
        @PathVariable(value = "id") id_course: Long
    ): MutableList<LessonInfo> {
        return lessonQueryService.findLessonByIdCourse(id_course)
    }

    @GetMapping("/lessons")
    fun getLessonById(): MutableList<LessonInfo> {
        return lessonQueryService.findAll()
    }
}