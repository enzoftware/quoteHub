package com.enzoftware.projects.ui.register.presenter

import com.enzoftware.projects.common.arePasswordsSame
import com.enzoftware.projects.common.isEmailValid
import com.enzoftware.projects.common.isPasswordValid
import com.enzoftware.projects.common.isUsernameValid
import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.firebase.database.FirebaseDatabaseInterface
import com.enzoftware.projects.model.RegisterModel
import com.enzoftware.projects.ui.register.view.RegisterView
import javax.inject.Inject

class RegisterPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : RegisterPresenter {

    private lateinit var view: RegisterView

    private val userData = RegisterModel()

    override fun onUsernameChanged(username: String) {
        userData.username = username

        if (!isUsernameValid(username)) {
            view.showUsernameError()
        }
    }

    override fun onEmailChanged(email: String) {
        userData.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        userData.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun onRepeatPasswordChanged(repeatPassword: String) {
        userData.repeatPassword = repeatPassword

        if (!arePasswordsSame(userData.password, repeatPassword)) {
            view.showPasswordMatchingError()
        }
    }

    override fun onRegisterClicked() {
        if (userData.isValid()) {
            val (name, email, password) = userData
            authenticationInterface.register(email, password, name) { isSuccessful ->
                onRegisterResult(isSuccessful, name, email)
            }
        }
    }

    override fun setView(view: RegisterView) {
        this.view = view
    }

    private fun onRegisterResult(isSuccessful: Boolean, username: String, email: String) {
        if (!isSuccessful) {
            createUser(username, email)
            view.onRegisterSuccess()
        } else {
            view.showSignUpError()
        }
    }

    private fun createUser(username: String, email: String) {
        val id = authenticationInterface.getUserId()

        databaseInterface.createUser(id, username, email)

    }

}