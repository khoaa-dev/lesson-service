package com.intern.lessonservice.cqrs.query.domain

import javax.persistence.*

@Entity
@Table(name = "quiz")
data class QuizInfo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 1,

    @Column(name = "title")
    var title: String? = "",

    @Column(name = "id_lesson")
    var idLesson: Long? = 1,
)
