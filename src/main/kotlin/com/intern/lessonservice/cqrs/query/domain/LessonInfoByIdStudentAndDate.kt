package com.intern.lessonservice.cqrs.query.domain

data class LessonInfoByIdStudentAndDate(
    var id: Long? = 1,
    var courseId: Long? = 1,
    var nameCourse: String? = null,
    var status: String? = "",
    var timeStart: String? = "",
    var timeEnd: String? = ""

)
