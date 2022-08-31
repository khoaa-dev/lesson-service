package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.command.domain.LessonCmd
import com.intern.lessonservice.cqrs.command.repositories.LessonCmdRepository
import com.intern.lessonservice.cqrs.command.services.LessonCmdService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LessonCommandController (val lessonCmdRepository: LessonCmdRepository){
    @PostMapping("/lessons")
    fun createNewLesson(@Valid @RequestBody lessonCmd: LessonCmd): LessonCmd =
            lessonCmdRepository.save(lessonCmd)

    //update
    @PutMapping("/lessons/status/{id}")
    fun updateStatusById(
            @PathVariable(value = "id") lessonId: Long,
            @Valid @RequestBody newStatus: LessonCmd): ResponseEntity<LessonCmd> {

        return lessonCmdRepository.findById(lessonId).map { existingLesson ->
            val updatedLesson: LessonCmd = existingLesson
                    .copy(status = newStatus.status,
                            realTimeStart = newStatus.realTimeStart,
                            realTimeEnd = newStatus.realTimeEnd)
            ResponseEntity.ok().body(lessonCmdRepository.save(updatedLesson))
        }.orElse(ResponseEntity.notFound().build())
    }
}

