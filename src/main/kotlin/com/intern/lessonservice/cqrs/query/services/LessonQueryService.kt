package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.query.domain.CourseInfo
import com.intern.lessonservice.cqrs.query.domain.LessonInfo
import com.intern.lessonservice.cqrs.query.repositories.CourseInfoRepository
import com.intern.lessonservice.cqrs.query.repositories.LessonInfoRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Service
class LessonQueryService (
    val lessonInfoRepository: LessonInfoRepository,
    val courseInfoRepository: CourseInfoRepository
) {

    fun findLessonByIdCourse(id_course: Long): MutableList<LessonInfo> {
        return lessonInfoRepository.findLessonByCourseId(id_course)
    }

    fun findAll(): MutableList<LessonInfo> {
        return lessonInfoRepository.findAll()
    }

    fun findAllLessonByDate(id_student: Long, date: String): MutableList<LessonInfo> {
        var lessonListToday: MutableList<LessonInfo> = mutableListOf()
        var courseList = courseInfoRepository.findCourseByIdStudent(id_student)

        for (course: CourseInfo in courseList) {
            var lessonList = lessonInfoRepository.findByCourseIdAndTimeStartIgnoreCaseContaining(course.id, date)
            for (lesson: LessonInfo in lessonList) {
                lessonListToday.add(lesson)
            }
        }
        return lessonListToday
    }
}
