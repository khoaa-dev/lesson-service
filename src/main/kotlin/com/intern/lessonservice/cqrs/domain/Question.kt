package com.intern.lessonservice.cqrs.domain

import javax.persistence.*


@Entity
@Table(name = "question")
data class Question(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 1,

    @Column(name = "id_quiz")
    var quizId: Long? = 1,

    @Column(name = "question")
    var question: String? = "",

    @Column(name = "answer_a")
    var answer_a: String? = "",

    @Column(name = "status_a")
    var status_a: Boolean? = null,

    @Column(name = "answer_b")
    var answer_b: String? = "",

    @Column(name = "status_b")
    var status_b: Boolean? = null,

    @Column(name = "answer_c")
    var answer_c: String? = "",

    @Column(name = "status_c")
    var status_c: Boolean? = null,

    @Column(name = "answer_d")
    var answer_d: String? = "",

    @Column(name = "status_d")
    var status_d: Boolean? = null,
)