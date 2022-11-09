package com.intern.lessonservice.cqrs.command.domain

import javax.persistence.*

@Entity
@Table(name = "lesson")
data class LessonCmd(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 1,

        @Column(name = "id_course")
        var courseId: Int?,

        @Column(name = "statuss")
        var status: String? = "",

        @Column(name = "time_start")
        var timeStart: String? = "",

        @Column(name = "time_end")
        var timeEnd: String? = ""
)