package com.intern.lessonservice.cqrs.command.domain


data class Answer (
    var answer: String? = "",
    var status: Boolean? = false
) {

}