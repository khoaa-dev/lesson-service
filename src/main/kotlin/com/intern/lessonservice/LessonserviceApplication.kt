package com.intern.lessonservice

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition
@SpringBootApplication
class LessonserviceApplication

fun main(args: Array<String>) {
	runApplication<LessonserviceApplication>(*args)
}
