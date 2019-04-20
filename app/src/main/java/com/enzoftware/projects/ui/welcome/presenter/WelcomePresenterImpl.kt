package com.enzoftware.projects.ui.welcome.presenter

import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.ui.welcome.view.WelcomeView
import javax.inject.Inject

class WelcomePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface
) : WelcomePresenter {

    private lateinit var view: WelcomeView

    override fun viewReady() {
        if (authenticationInterface.getUserId().isNotBlank()) {
            view.startMainScreen()
        }
    }

    override fun setView(view: WelcomeView) {
        this.view = view
    }

}