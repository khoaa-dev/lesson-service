package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.command.domain.LessonCmd
import com.intern.lessonservice.cqrs.command.repositories.LessonCmdRepository
import org.springframework.http.ResponseEntity

class LessonCmdService (val lessonCmdRepository: LessonCmdRepository){

}