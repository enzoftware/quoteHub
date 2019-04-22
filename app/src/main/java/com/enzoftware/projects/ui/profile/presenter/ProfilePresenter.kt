package com.enzoftware.projects.ui.profile.presenter

import com.enzoftware.projects.ui.base.BasePresenter
import com.enzoftware.projects.ui.profile.view.ProfileView

interface ProfilePresenter : BasePresenter<ProfileView> {

    fun getProfile()

    fun logout()

}