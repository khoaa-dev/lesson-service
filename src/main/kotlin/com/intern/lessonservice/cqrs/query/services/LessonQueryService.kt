package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.query.domain.LessonInfo
import com.intern.lessonservice.cqrs.query.repositories.LessonInfoRepository
import org.springframework.stereotype.Service

@Service
class LessonQueryService (val lessonInfoRepository: LessonInfoRepository) {

    fun findLessonByIdCourse(id_course: Long): MutableList<LessonInfo> {
        return lessonInfoRepository.findLessonByCourseId(id_course)
    }

    fun findAll(): MutableList<LessonInfo> {
        return lessonInfoRepository.findAll()
    }
}
