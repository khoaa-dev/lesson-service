package com.intern.lessonservice.cqrs.command.repositories

import com.intern.lessonservice.cqrs.command.domain.Course
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository : JpaRepository<Course, Long>