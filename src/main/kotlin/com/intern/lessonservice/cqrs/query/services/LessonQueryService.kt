package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.query.domain.CourseInfo
import com.intern.lessonservice.cqrs.query.domain.LessonInfo
import com.intern.lessonservice.cqrs.query.domain.LessonInfoByIdStudentAndDate
import com.intern.lessonservice.cqrs.query.repositories.CourseInfoRepository
import com.intern.lessonservice.cqrs.query.repositories.LessonInfoRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Service
class LessonQueryService (
    val lessonInfoRepository: LessonInfoRepository,
    val courseInfoRepository: CourseInfoRepository
) {

    fun findLessonByIdCourse(id_course: Long): MutableList<LessonInfo> {
        return lessonInfoRepository.findByCourseId(id_course)
    }

    fun findAll(): MutableList<LessonInfo> {
        return lessonInfoRepository.findAll()
    }

    fun findLessonByStudentIdAndDate(id_student: Long, date: String): MutableList<LessonInfoByIdStudentAndDate> {
        var lessonListToday: MutableList<LessonInfoByIdStudentAndDate> = mutableListOf()
        var courseList = courseInfoRepository.findByIdStudent(id_student)

        for (course: CourseInfo in courseList) {
            var lessonInfoByIdStudentAndDate = LessonInfoByIdStudentAndDate()
            var nameCourse = course.nameCourse
            lessonInfoByIdStudentAndDate.nameCourse = nameCourse
            var lessonList = lessonInfoRepository.findByCourseIdAndTimeStartIgnoreCaseContaining(course.id, date)
            for (lesson: LessonInfo in lessonList) {
                lessonInfoByIdStudentAndDate.id = lesson.id
                lessonInfoByIdStudentAndDate.courseId = lesson.courseId
                lessonInfoByIdStudentAndDate.status = lesson.status
                lessonInfoByIdStudentAndDate.timeStart = lesson.timeStart
                lessonInfoByIdStudentAndDate.timeEnd = lesson.timeEnd
                lessonListToday.add(lessonInfoByIdStudentAndDate)
            }
        }
        return lessonListToday
    }

    fun findLessonByTeacherIdAndDate(id_teacher: Long, date: String): MutableList<LessonInfo> {
        var listLesson: MutableList<LessonInfo> = mutableListOf()
        var courseList = courseInfoRepository.findByIdTeacher(id_teacher)

        for (course: CourseInfo in courseList) {
            var lessonList = lessonInfoRepository.findByCourseIdAndTimeStartIgnoreCaseContaining(course.id, date)
            for (lesson: LessonInfo in lessonList) {
                listLesson.add(lesson)
            }
        }
        return listLesson
    }

    fun findCourseByIdLesson(id_lesson: Long): Optional<CourseInfo>? {
        val lesson = lessonInfoRepository.findById(id_lesson)
        var course = lesson?.get()?.courseId?.let { courseInfoRepository.findById(it) }
        return course
    }
}
