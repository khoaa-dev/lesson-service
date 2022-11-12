package com.intern.lessonservice.firebase

data class FirebaseCredential (
    var type: String? = null,
    var project_id: String? = null,
    var private_key_id: String? = null,
    var private_key: String? = null,
    var client_email: String? = null,
    var client_id: String? = null,
    var auth_uri: String? = null,
    var token_uri: String? = null,
    var auth_provider_x509_cert_url: String? = null,
    var client_x509_cert_url: String? = null
)