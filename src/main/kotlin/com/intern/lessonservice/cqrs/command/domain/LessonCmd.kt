package com.intern.lessonservice.cqrs.command.domain

import java.sql.Date
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "lesson")
data class LessonCmd(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 1,

        @Column(name = "id_course")
        var courseId: Int?,

        @Column(name = "statuss")
        var status: Int? = -1,

        @Column(name = "time_start")
        var timeStart: String? = "mm/dd/yyyy HH:mm:ss",

        @Column(name = "time_end")
        var timeEnd: String? = "mm/dd/yyyy HH:mm:ss"
)