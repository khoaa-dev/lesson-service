package com.intern.lessonservice.cqrs.query.domain

import javax.persistence.*


@Entity
@Table(name = "lesson")
data class LessonInfo(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 1,

        @Column(name = "id_course")
        var courseId: Long? = 1,

        @Column(name = "statuss")
        var status: String? = "",

        @Column(name = "time_start")
        var timeStart: String? = "",

        @Column(name = "time_end")
        var timeEnd: String? = ""
)