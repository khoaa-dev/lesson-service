package com.intern.lessonservice.cqrs.command.domain

import javax.persistence.*

@Entity
@Table(name = "quiz")
data class Quiz(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 1,

    @Column(name = "title")
    var title: String? = "",

    @Column(name = "id_lesson")
    var id_lesson: Long? = 1,

)
