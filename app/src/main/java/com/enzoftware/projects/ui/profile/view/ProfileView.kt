package com.enzoftware.projects.ui.profile.view

interface ProfileView {

    fun showUsername(username: String)

    fun showEmail(email: String)

    fun showNumberOfQuotes(quotes: Int)

    fun openWelcome()

}