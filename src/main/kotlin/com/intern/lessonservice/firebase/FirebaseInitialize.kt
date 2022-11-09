package com.intern.lessonservice.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.stereotype.Service
import java.io.FileInputStream
import javax.annotation.PostConstruct


@Service
class FirebaseInitialize {
    @PostConstruct
    open fun initialize() {
        try {
            val evtutorQuiz = FileInputStream("./evtutor-quiz-firebase.json")
            val options: FirebaseOptions = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(evtutorQuiz))
                .setDatabaseUrl("https://evtutor-quiz-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build()
            FirebaseApp.initializeApp(options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}