package com.enzoftware.projects.ui.profile.presenter

import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.firebase.database.FirebaseDatabaseInterface
import com.enzoftware.projects.ui.profile.view.ProfileView
import javax.inject.Inject

class ProfilePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : ProfilePresenter {

    private lateinit var view: ProfileView

    override fun getProfile() {
        databaseInterface.getProfile(authenticationInterface.getUserId()) { it ->
            val userId = authenticationInterface.getUserId()
            view.showUsername(it.username)
            view.showEmail(it.email)
            view.showNumberOfQuotes(it.quotes.count { it.authorId == userId })

        }
    }

    override fun logout() {
        authenticationInterface.logout {
            view.openWelcome()
        }
    }

    override fun setView(view: ProfileView) {
        this.view = view
    }

}