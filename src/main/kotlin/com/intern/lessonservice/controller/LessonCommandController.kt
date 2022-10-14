package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.command.domain.LessonCmd
import com.intern.lessonservice.cqrs.command.repositories.LessonCmdRepository
import com.intern.lessonservice.cqrs.command.services.LessonCmdService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LessonCommandController (val lessonCmdService: LessonCmdService){
    @PostMapping("/lessons")
    fun createNewLesson(@Valid @RequestBody lessonCmd: LessonCmd): LessonCmd {
        return lessonCmdService.addLesson(lessonCmd)
    }


    //update
    @PutMapping("/lessons/id_lesson={id}")
    fun updateStatusById(
            @PathVariable(value = "id") lessonId: Long,
            @Valid @RequestBody updateLesson: LessonCmd): ResponseEntity<LessonCmd> {

        return lessonCmdService.updateLessonInfo(lessonId, updateLesson)
    }
}

