package com.intern.lessonservice.cqrs.command.domain

import javax.persistence.*

@Entity
@Table(name = "lesson")
data class LessonCmd(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 1,

        @Column(name = "id_student")
        var idStudent: Long? = 1,

        @Column(name = "id_teacher")
        var idTeacher: Long? = 1,

        @Column(name = "statuss")
        var status: String? = "",

        @Column(name = "time_start")
        var timeStart: String? = "",

        @Column(name = "time_end")
        var timeEnd: String? = "",

        @Column(name = "real_time_start")
        var realTimeStart: String? = "",

        @Column(name = "real_time_end")
        var realTimeEnd: String? = "",


        @Column(name = "channel_name")
        var channelName: String? = ""
)