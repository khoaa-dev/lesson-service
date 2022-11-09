package com.intern.lessonservice.cqrs.command.services

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.*
import com.google.firebase.cloud.FirestoreClient
import com.intern.lessonservice.cqrs.command.domain.Quiz
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.ExecutionException


@Service
class QuizService {
    val COLLECTION_NAME="evtutor_quiz"

    @Throws(InterruptedException::class, ExecutionException::class)
    fun saveQuizDetails(quiz: Quiz): Quiz {
        var id = UUID.randomUUID()
        quiz.id = id.toString()
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        dbFirestore.collection(COLLECTION_NAME).document(quiz.id.toString()).set(quiz)
        return quiz
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun updateQuizDetails(quiz: Quiz): Quiz {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        dbFirestore.collection(COLLECTION_NAME).document(quiz.id.toString()).set(quiz)
        return quiz
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    fun getQuizByLessonId(lessonId: Long): MutableList<Quiz> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val documentReference = dbFirestore.collection(COLLECTION_NAME)
        val query: Query = documentReference.whereEqualTo("idLesson", lessonId)
        val querySnapshot = query.get()
        val documents: List<QueryDocumentSnapshot> = querySnapshot.get().documents
        var listQuiz: MutableList<Quiz> = mutableListOf()
        for (document in documents) {
            listQuiz.add(document.toObject(Quiz::class.java))
        }
        return listQuiz
    }

    fun deleteQuiz(quizId: String): List<String> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val writeResult: ApiFuture<WriteResult> = dbFirestore.collection(COLLECTION_NAME).document(quizId).delete()
        return listOf<String>("Quiz with ID $quizId has been deleted")
    }
}