package com.intern.lessonservice.cqrs.domain

import javax.persistence.*

@Entity
@Table(name = "quiz")
data class Quiz(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 1,

    @Column(name = "title")
    var title: String? = "",

    @Column(name = "id_lesson")
    var lessonId: Long? = 1,

)
