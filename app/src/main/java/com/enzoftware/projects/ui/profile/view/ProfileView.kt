package com.enzoftware.projects.ui.profile.view

interface ProfileView {

    fun showUsername(username: String)

    fun showEmail(email: String)

    fun showNumberOfQuotes(jokes: Int)

    fun openWelcome()

}