package com.enzoftware.projects.ui.welcome

import android.content.Intent
import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.common.onClick
import com.enzoftware.projects.ui.base.BaseActivity
import com.enzoftware.projects.ui.home.HomeActivity
import com.enzoftware.projects.ui.login.LoginActivity
import com.enzoftware.projects.ui.register.RegisterActivity
import com.enzoftware.projects.ui.welcome.view.WelcomeView
import com.enzoftware.projects.welcomePresenter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : BaseActivity(), WelcomeView {
    override fun startMainScreen() {
        startActivity(HomeActivity.getLaunchIntent(this))
    }

    private val presenter by lazy { welcomePresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        presenter.setView(this)
        presenter.viewReady()
        registerButton.onClick { startActivity(Intent(this, RegisterActivity::class.java)) }
        loginButton.onClick { startActivity(Intent(this, LoginActivity::class.java)) }
    }

}
