package com.intern.lessonservice.cqrs.query.repositories

import com.intern.lessonservice.cqrs.query.domain.LessonInfo
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LessonInfoRepository : JpaRepository<LessonInfo, Long> {
    @Query("SELECT * FROM lesson WHERE id_course = '%:id_course%'")
    fun findLessonByCourseId(id_course: Long): MutableList<LessonInfo>
}