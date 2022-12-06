package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.domain.Lesson
import com.intern.lessonservice.cqrs.command.services.LessonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LessonCommandController (val lessonService: LessonService){
    @PostMapping("/lessons")
    fun createNewLesson(@Valid @RequestBody lessonCmd: Lesson): Lesson {
        return lessonService.addLesson(lessonCmd)
    }


    //update
    @PutMapping("/lessons/id_lesson={id}")
    fun updateStatusById(
            @PathVariable(value = "id") lessonId: Long,
            @Valid @RequestBody updateLesson: Lesson
    ): ResponseEntity<Lesson> {

        return lessonService.updateLessonInfo(lessonId, updateLesson)
    }
}

