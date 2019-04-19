package com.enzoftware.projects.ui.welcome.presenter

import com.enzoftware.projects.ui.base.BasePresenter
import com.enzoftware.projects.ui.welcome.view.WelcomeView

interface WelcomePresenter : BasePresenter<WelcomeView> {

    fun viewReady()

}