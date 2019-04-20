package com.enzoftware.projects.firebase.authentication

import javax.inject.Inject

class FirebaseAuthenticationManager @Inject constructor() : FirebaseAuthenticationInterface {

    override fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserId(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun logout(onResult: () -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun register(email: String, password: String, username: String, onResult: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}