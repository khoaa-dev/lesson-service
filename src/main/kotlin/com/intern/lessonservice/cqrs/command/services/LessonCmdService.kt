package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.command.domain.LessonCmd
import com.intern.lessonservice.cqrs.command.repositories.LessonCmdRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.format.DateTimeFormatter

@Service
class LessonCmdService (private val lessonCmdRepository: LessonCmdRepository){
    fun addLesson(lessonCmd: LessonCmd) : LessonCmd = lessonCmdRepository.save(lessonCmd)

    fun updateLessonInfo(id: Long, lessonCmd: LessonCmd) : ResponseEntity<LessonCmd> {
        return lessonCmdRepository.findById(id).map { existingLesson ->
            val updateLesson : LessonCmd = existingLesson
                .copy(status = lessonCmd.status)
            ResponseEntity.ok().body(lessonCmdRepository.save((updateLesson)))
        }.orElse(ResponseEntity.notFound().build())
    }
}