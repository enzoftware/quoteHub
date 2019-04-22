package com.enzoftware.projects.ui.login.presenter

import com.enzoftware.projects.common.isEmailValid
import com.enzoftware.projects.common.isPasswordValid
import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.model.LoginModel
import com.enzoftware.projects.ui.login.view.LoginView
import javax.inject.Inject

class LoginPresenterImpl @Inject constructor(
    private val authentication: FirebaseAuthenticationInterface
) : LoginPresenter {

    private lateinit var view: LoginView

    private val loginRequest = LoginModel()

    override fun onLoginClicked() {
        if (loginRequest.isValid()) {
            authentication.login(loginRequest.email, loginRequest.password) { isSuccess ->
                if (isSuccess) {
                    view.onLoginSuccess()
                } else {
                    view.onLoginError()
                }
            }
        }
    }

    override fun onEmailChanged(email: String) {
        loginRequest.email = email

        if (!isEmailValid(email)) {
            view.showEmailError()
        }
    }

    override fun onPasswordChanged(password: String) {
        loginRequest.password = password

        if (!isPasswordValid(password)) {
            view.showPasswordError()
        }
    }

    override fun setView(view: LoginView) {
        this.view = view
    }

}