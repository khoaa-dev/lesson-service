package com.intern.lessonservice.firebase

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.apache.commons.io.IOUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import java.io.FileInputStream
import java.io.InputStream
import javax.annotation.PostConstruct



@Service
@PropertySource("classpath:FirebaseEnvironmentVariables.properties")
class FirebaseInitialize {
    @Autowired
    lateinit var env: Environment

    var projectId: String = ""

    @PostConstruct
    open fun initialize() {
        projectId = System.getenv("FIREBASE_PROJECT_ID")
        try {
            val firebaseCredential: InputStream?= createFirebaseCredential()
            val options: FirebaseOptions = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(firebaseCredential))
                .setDatabaseUrl("https://evtutor-quiz-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build()
             FirebaseApp.initializeApp(options)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws(java.lang.Exception::class)
    private fun createFirebaseCredential(): InputStream? {
        val privateKey: String = System.getenv("FIREBASE_PRIVATE_KEY")!!.replace("\\n", "\n")
        val firebaseCredential = FirebaseCredential(
            System.getenv("FIREBASE_TYPE"),
            projectId,
            System.getenv("FIREBASE_PRIVATE_KEY_ID"),
            privateKey,
            System.getenv("FIREBASE_CLIENT_EMAIL"),
            System.getenv("FIREBASE_CLIENT_ID"),
            System.getenv("FIREBASE_AUTH_URI"),
            System.getenv("FIREBASE_TOKEN_URI"),
            System.getenv("FIREBASE_AUTH_PROVIDER_X509_CERT_URL"),
            System.getenv("FIREBASE_CLIENT_X509_CERT_URL")
        )

        //serialize with Jackson
        val mapper = ObjectMapper()
        val jsonString: String = mapper.writeValueAsString(firebaseCredential)

        //convert jsonString string to InputStream using Apache Commons
        return IOUtils.toInputStream(jsonString)
    }
}