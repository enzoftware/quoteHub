package com.enzoftware.projects.ui.login

import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.loginPresenter
import com.enzoftware.projects.ui.base.BaseActivity
import com.enzoftware.projects.ui.login.view.LoginView

class LoginActivity : BaseActivity(), LoginView {


    private val presenter by lazy { loginPresenter() }

    override fun onLoginSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoginError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmailError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPasswordError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
