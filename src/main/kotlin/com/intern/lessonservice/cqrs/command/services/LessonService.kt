package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.domain.Lesson
import com.intern.lessonservice.cqrs.repositories.LessonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class LessonService (private val lessonRepository: LessonRepository){
    fun addLesson(lessonCmd: Lesson) : Lesson = lessonRepository.save(lessonCmd)

    fun updateLessonInfo(id: Long, lessonCmd: Lesson) : ResponseEntity<Lesson> {
        return lessonRepository.findById(id).map { existingLesson ->
            val updateLesson : Lesson = existingLesson
                .copy(status = lessonCmd.status)
            ResponseEntity.ok().body(lessonRepository.save((updateLesson)))
        }.orElse(ResponseEntity.notFound().build())
    }
}