package com.intern.lessonservice.cqrs.query.services

import com.intern.lessonservice.cqrs.domain.Course
import com.intern.lessonservice.cqrs.domain.Lesson
import com.intern.lessonservice.cqrs.query.domain.LessonInfoByIdStudentAndDate
import com.intern.lessonservice.cqrs.repositories.CourseRepository
import com.intern.lessonservice.cqrs.repositories.LessonRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class LessonQueryService (
    val lessonRepository: LessonRepository,
    val courseRepository: CourseRepository
) {

    fun findLessonByIdCourse(id_course: Long): MutableList<Lesson> {
        return lessonRepository.findByCourseId(id_course)
    }

    fun findAll(): MutableList<Lesson> {
        return lessonRepository.findAll()
    }

    fun findLessonByStudentIdAndDate(id_student: Long, date: String): MutableList<LessonInfoByIdStudentAndDate> {
        var lessonListToday: MutableList<LessonInfoByIdStudentAndDate> = mutableListOf()
        var courseList = courseRepository.findByIdStudent(id_student)

        for (course: Course in courseList) {
            var lessonInfoByIdStudentAndDate = LessonInfoByIdStudentAndDate()
            var nameCourse = course.nameCourse
            lessonInfoByIdStudentAndDate.nameCourse = nameCourse
            var lessonList = lessonRepository.findByCourseIdAndTimeStartIgnoreCaseContaining(course.id, date)
            for (lesson: Lesson in lessonList) {
                lessonInfoByIdStudentAndDate.id = lesson.id
                lessonInfoByIdStudentAndDate.courseId = lesson.courseId
                lessonInfoByIdStudentAndDate.status = lesson.status.toString()
                lessonInfoByIdStudentAndDate.timeStart = lesson.timeStart
                lessonInfoByIdStudentAndDate.timeEnd = lesson.timeEnd
                lessonListToday.add(lessonInfoByIdStudentAndDate)
            }
        }
        return lessonListToday
    }

    fun findLessonByTeacherIdAndDate(id_teacher: Long, date: String): MutableList<Lesson> {
        var listLesson: MutableList<Lesson> = mutableListOf()
        var courseList = courseRepository.findByIdTeacher(id_teacher)

        for (course: Course in courseList) {
            var lessonList = lessonRepository.findByCourseIdAndTimeStartIgnoreCaseContaining(course.id, date)
            for (lesson: Lesson in lessonList) {
                listLesson.add(lesson)
            }
        }
        return listLesson
    }

    fun findCourseByIdLesson(id_lesson: Long): Optional<Course>? {
        val lesson = lessonRepository.findById(id_lesson)
        var course = lesson?.get()?.courseId?.let { courseRepository.findById(it) }
        return course
    }
}
