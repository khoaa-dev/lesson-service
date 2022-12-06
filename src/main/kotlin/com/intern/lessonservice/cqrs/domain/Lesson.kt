package com.intern.lessonservice.cqrs.domain

import javax.persistence.*

@Entity
@Table(name = "lesson")
data class Lesson(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 1,

        @Column(name = "id_course")
        var courseId: Long?,

        @Column(name = "statuss")
        var status: Int? = -1,

        @Column(name = "time_start")
        var timeStart: String? = "mm/dd/yyyy HH:mm:ss",

        @Column(name = "time_end")
        var timeEnd: String? = "mm/dd/yyyy HH:mm:ss"
)