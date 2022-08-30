package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.command.domain.LessonCmd
import com.intern.lessonservice.cqrs.command.repositories.LessonCmdRepository
import org.springframework.http.ResponseEntity

class LessonCmdService (val lessonCmdRepository: LessonCmdRepository){
    //    //create
    fun createNewLesson(lessonCmd: LessonCmd): ResponseEntity<LessonCmd> {
        return ResponseEntity.ok(lessonCmdRepository.save(lessonCmd))
    }

//    //update
    fun updateStatus(lessonId: Long, newStatus: LessonCmd): ResponseEntity<LessonCmd> {
        return lessonCmdRepository.findById(lessonId).map { currentStatus->
            val updatedStatus: LessonCmd =
                    currentStatus
                            .copy(
                                    status = newStatus.status
                            )
            ResponseEntity.ok().body(lessonCmdRepository.save(updatedStatus))
        }.orElse(ResponseEntity.notFound().build())
    }
}