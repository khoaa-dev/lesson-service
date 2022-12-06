package com.intern.lessonservice.controller

import com.intern.lessonservice.cqrs.domain.Course
import com.intern.lessonservice.cqrs.command.services.CourseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class CourseCommandController(val courseService: CourseService) {
    @PostMapping("/course")
    fun addCourse(@Valid @RequestBody course: Course): Course {
        return courseService.addCourse(course)
    }

    @PutMapping("/updateIDStudent/id_course={id_course}")
    fun updateIDStudent(
        @PathVariable(value = "id_course") id_course: Long,
        @Valid @RequestBody course: Course,
    ) : ResponseEntity<Course> {
        return courseService.updateCourseInfo(id_course, course)
    }

}