package com.intern.lessonservice.cqrs.domain

import java.sql.Date
import javax.persistence.*


@Entity
@Table(name = "course")
data class Course(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 1,

    @Column(name = "name_course")
    var nameCourse: String? = "",

    @Column(name = "id_student")
    var idStudent: Long? = 1,

    @Column(name = "id_teacher")
    var idTeacher: Long? = 1,

    @Column(name = "tutor_fee")
    var tutorFee: Double?,

    @Column(name = "date_created")
    var dateCreated: Date?,

)
