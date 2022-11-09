package com.intern.lessonservice.cqrs.command.domain

import com.google.auto.value.AutoValue.Builder
import java.util.UUID

@Builder
class Quiz(
    var id: String? = "",
    var idLesson: Long? = 1,
    var title: String? = "",
    var question: String? = "",
    var answerA: Answer? = null,
    var answerB: Answer? = null,
    var answerC: Answer? = null,
    var answerD: Answer? = null,
)