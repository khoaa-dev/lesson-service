package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.query.domain.Lesson
import com.intern.lessonservice.cqrs.query.repositories.LessonRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class LessonService (val lessonRepository: LessonRepository)
{
    fun findAll(): MutableList<Lesson> {
        return lessonRepository.findAll()
    }

    fun findById(lessonId: Long): ResponseEntity<Lesson> {
        return lessonRepository.findById(lessonId).map { lesson ->
            ResponseEntity.ok(lesson)
        }.orElse(ResponseEntity.notFound().build())
    }
}
