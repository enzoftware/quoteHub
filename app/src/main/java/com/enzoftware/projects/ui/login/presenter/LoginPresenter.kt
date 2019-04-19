package com.enzoftware.projects.ui.login.presenter

import com.enzoftware.projects.ui.base.BasePresenter
import com.enzoftware.projects.ui.login.view.LoginView

interface LoginPresenter : BasePresenter<LoginView> {

    fun onLoginClicked()

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

}