package com.enzoftware.projects.firebase.authentication

interface FirebaseAuthentication {
    fun login(email: String, password: String, onResult: (Boolean) -> Unit)
    fun getUserId(): String
    fun getUserName(): String
    fun logout(onResult: () -> Unit)
    fun register(email: String, password: String, username: String, onResult: (Boolean) -> Unit)
}