package com.intern.lessonservice.cqrs.query.repositories

import com.intern.lessonservice.cqrs.query.domain.CourseInfo
//import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import org.springframework.stereotype.Repository

@Repository
interface CourseInfoRepository : JpaRepository<CourseInfo, Long> {
//    @Query("SELECT * FROM course WHERE id_teacher = '%:id_teacher%'")
    fun findByIdTeacher(id_teacher: Long): MutableList<CourseInfo>

//    @Query("SELECT * FROM course WHERE id_student = '%:id_student%'")
    fun findByIdStudent(id_student: Long): MutableList<CourseInfo>
}