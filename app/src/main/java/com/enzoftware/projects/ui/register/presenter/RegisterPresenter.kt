package com.enzoftware.projects.ui.register.presenter

import com.enzoftware.projects.ui.base.BasePresenter
import com.enzoftware.projects.ui.register.view.RegisterView

interface RegisterPresenter : BasePresenter<RegisterView> {

    fun onUsernameChanged(username: String)

    fun onEmailChanged(email: String)

    fun onPasswordChanged(password: String)

    fun onRepeatPasswordChanged(repeatPassword: String)

    fun onRegisterClicked()

}