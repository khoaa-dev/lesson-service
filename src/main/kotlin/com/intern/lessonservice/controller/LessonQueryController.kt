package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.domain.Course
import com.intern.lessonservice.cqrs.domain.Lesson
import com.intern.lessonservice.cqrs.query.domain.LessonInfoByIdStudentAndDate
import com.intern.lessonservice.cqrs.query.services.LessonQueryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api")
class LessonQueryController (val lessonQueryService: LessonQueryService){

    @GetMapping("/lessons/id_course={id}")
    fun getLessonById(
        @PathVariable(value = "id") id_course: Long
    ): MutableList<Lesson> {
        return lessonQueryService.findLessonByIdCourse(id_course)
    }

    @GetMapping("/lessons")
    fun getLessonById(): MutableList<Lesson> {
        return lessonQueryService.findAll()
    }

    @GetMapping("/lessonByDate/id_student={id_student}&date={date}")
    fun getLessonByStudentIdAndDate(@PathVariable(value = "id_student") id_student: Long,
        @PathVariable(value = "date") date: String
    ): MutableList<LessonInfoByIdStudentAndDate> {
        return lessonQueryService.findLessonByStudentIdAndDate(id_student, date)
    }

    @GetMapping("/lessonByDate/id_teacher={id_teacher}&date={date}")
    fun getLessonByTeachertIdAndDate(@PathVariable(value = "id_teacher") id_teacher: Long,
                               @PathVariable(value = "date") date: String
    ): MutableList<Lesson> {
        return lessonQueryService.findLessonByTeacherIdAndDate(id_teacher, date)
    }

    @GetMapping("/courseInfo/id_lesson={id_lesson}")
    fun getCourseInfoByIdLesson(@PathVariable(value = "id_lesson") id_lesson: Long
    ): Optional<Course>? {
        return lessonQueryService.findCourseByIdLesson(id_lesson)
    }
}