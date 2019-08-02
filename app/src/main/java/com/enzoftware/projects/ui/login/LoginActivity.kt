package com.enzoftware.projects.ui.login

import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.common.onClick
import com.enzoftware.projects.common.onTextChanged
import com.enzoftware.projects.common.showGeneralError
import com.enzoftware.projects.loginPresenter
import com.enzoftware.projects.ui.base.BaseActivity
import com.enzoftware.projects.ui.home.HomeActivity
import com.enzoftware.projects.ui.login.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView {

    private val presenter by lazy { loginPresenter() }

    override fun onLoginSuccess() = startActivity(HomeActivity.getLaunchIntent(this))

    override fun onLoginError() = showGeneralError(this)

    override fun showEmailError() {
        emailInput.error = getString(R.string.password_error)
    }

    override fun showPasswordError() {
        passwordInput.error = getString(R.string.email_error)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        emailInput.onTextChanged {
            presenter.onEmailChanged(it!!)
        }
        passwordInput.onTextChanged {
            presenter.onPasswordChanged(it!!)
        }
        loginButton.onClick {
            presenter.onLoginClicked()
        }
    }
}
