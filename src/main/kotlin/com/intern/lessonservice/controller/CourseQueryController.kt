package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.query.domain.CourseInfo
import com.intern.lessonservice.cqrs.query.services.CourseQueryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CourseQueryController(val courseQueryService: CourseQueryService) {
    @GetMapping("/course/id_course={id_course}")
    fun getCourseByCourseId(@PathVariable(value="id_course") id_course : Long): ResponseEntity<CourseInfo> {
        return courseQueryService.findByCourseId(id_course)
    }

    @GetMapping("/course/id_teacher={id_teacher}")
    fun getCourseByTeacherId(@PathVariable(value = "id_teacher") id_teacher: Long): MutableList<CourseInfo> {
        return courseQueryService.findByTeacherId(id_teacher)
    }

}