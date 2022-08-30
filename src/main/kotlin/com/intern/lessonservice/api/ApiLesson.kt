package com.intern.lessonservice.api

data class ApiLesson (
        val idStudent: Long?,
        val idTeacher: Long?,
        val status: String?,
        val timeStart: String?,
        val timeEnd: String?,
        val realTimeStart: String?,
        val realTimeEnd: String?,
        val channelName: String?
)