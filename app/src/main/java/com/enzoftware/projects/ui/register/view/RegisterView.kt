package com.enzoftware.projects.ui.register.view

interface RegisterView {

    fun onRegisterSuccess()

    fun showSignUpError()

    fun showUsernameError()

    fun showEmailError()

    fun showPasswordError()

    fun showPasswordMatchingError()

}