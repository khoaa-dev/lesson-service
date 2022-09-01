package com.intern.lessonservice

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication


@SpringBootApplication
class LessonserviceApplication

fun main(args: Array<String>) {
	runApplication<LessonserviceApplication>(*args)
}
