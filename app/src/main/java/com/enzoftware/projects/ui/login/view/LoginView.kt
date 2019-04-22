package com.enzoftware.projects.ui.login.view

interface LoginView {

    fun onLoginSuccess()

    fun onLoginError()

    fun showEmailError()

    fun showPasswordError()

}