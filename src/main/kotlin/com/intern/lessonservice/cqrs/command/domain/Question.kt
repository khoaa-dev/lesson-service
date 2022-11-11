package com.intern.lessonservice.cqrs.command.domain

import com.google.auto.value.AutoValue.Builder

@Builder
class Question(
    var id: String? = "",
    var idQuiz: Long? = 1,
    var question: String? = "",
    var answerA: Answer? = null,
    var answerB: Answer? = null,
    var answerC: Answer? = null,
    var answerD: Answer? = null,
)