package com.enzoftware.projects.firebase.authentication

import javax.inject.Inject

class FirebaseAuthenticationManager @Inject constructor() : FirebaseAuthenticationInterface {

    override fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
    }

    override fun getUserId(): String {
        return ""
    }

    override fun getUserName(): String {
        return ""
    }

    override fun logout(onResult: () -> Unit) {
    }

    override fun register(email: String, password: String, username: String, onResult: (Boolean) -> Unit) {
    }

}