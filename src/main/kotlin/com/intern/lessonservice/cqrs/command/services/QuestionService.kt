package com.intern.lessonservice.cqrs.command.services

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.*
import com.google.firebase.cloud.FirestoreClient
import com.intern.lessonservice.cqrs.command.domain.Question
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ExecutionException


@Service
class QuestionService {
    val COLLECTION_NAME="evtutor_quiz"

    @Throws(InterruptedException::class, ExecutionException::class)
    fun saveQuestionDetails(question: Question): Question {
        var id = UUID.randomUUID()
        question.id = id.toString()
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        dbFirestore.collection(COLLECTION_NAME).document(question.id.toString()).set(question)
        return question
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun updateQuestionDetails(question: Question): Question {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        dbFirestore.collection(COLLECTION_NAME).document(question.id.toString()).set(question)
        return question
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun getQuestionByQuizId(quizId: Long): MutableList<Question> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val documentReference = dbFirestore.collection(COLLECTION_NAME)
        val query: Query = documentReference.whereEqualTo("idQuiz", quizId)
        val querySnapshot = query.get()
        val documents: List<QueryDocumentSnapshot> = querySnapshot.get().documents
        var listQuestion: MutableList<Question> = mutableListOf()
        for (document in documents) {
            listQuestion.add(document.toObject(Question::class.java))
        }
        return listQuestion
    }

    fun deleteQuestion(questionId: String): List<String> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val writeResult: ApiFuture<WriteResult> = dbFirestore.collection(COLLECTION_NAME).document(questionId).delete()
        return listOf<String>("Quiz with ID $questionId has been deleted")
    }
}