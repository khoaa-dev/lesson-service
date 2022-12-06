package com.intern.lessonservice.cqrs.command.services

import com.intern.lessonservice.cqrs.domain.Question
import com.intern.lessonservice.cqrs.repositories.QuestionRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class QuestionService(private val questionRepository: QuestionRepository) {
    fun addQuestion(question: Question): Question = questionRepository.save(question)

    fun updateQuestionInfo(id_question: Long, question: Question): ResponseEntity<Question> {
        return questionRepository.findById(id_question).map { existingQuestion ->
            val updateQuestion: Question = existingQuestion
                .copy(question = question.question,
                    answer_a = question.answer_a,
                    status_a = question.status_a,
                    answer_b = question.answer_b,
                    status_b = question.status_b,
                    answer_c = question.answer_c,
                    status_c = question.status_c,
                    answer_d = question.answer_d,
                    status_d = question.status_d)

            ResponseEntity.ok().body(questionRepository.save(updateQuestion))
        }.orElse(ResponseEntity.notFound().build())
    }




//    val COLLECTION_NAME="evtutor_quiz"
//
//    @Throws(InterruptedException::class, ExecutionException::class)
//    fun saveQuestionDetails(question: Question): Question {
//        var id = UUID.randomUUID()
//        question.id = id.toString()
//        val dbFirestore: Firestore = FirestoreClient.getFirestore()
//        dbFirestore.collection(COLLECTION_NAME).document(question.id.toString()).set(question)
//        return question
//    }
//
//    @Throws(InterruptedException::class, ExecutionException::class)
//    fun updateQuestionDetails(question: Question): Question {
//        val dbFirestore: Firestore = FirestoreClient.getFirestore()
//        dbFirestore.collection(COLLECTION_NAME).document(question.id.toString()).set(question)
//        return question
//    }
//
//    @Throws(InterruptedException::class, ExecutionException::class)
//    fun getQuestionByQuizId(quizId: Long): MutableList<Question> {
//        val dbFirestore: Firestore = FirestoreClient.getFirestore()
//        val documentReference = dbFirestore.collection(COLLECTION_NAME)
//        val query: Query = documentReference.whereEqualTo("idQuiz", quizId)
//        val querySnapshot = query.get()
//        val documents: List<QueryDocumentSnapshot> = querySnapshot.get().documents
//        var listQuestion: MutableList<Question> = mutableListOf()
//        for (document in documents) {
//            listQuestion.add(document.toObject(Question::class.java))
//        }
//        return listQuestion
//    }
//
//    fun deleteQuestion(questionId: String): List<String> {
//        val dbFirestore: Firestore = FirestoreClient.getFirestore()
//        val writeResult: ApiFuture<WriteResult> = dbFirestore.collection(COLLECTION_NAME).document(questionId).delete()
//        return listOf<String>("Quiz with ID $questionId has been deleted")
//    }
}