package com.enzoftware.projects.ui.register

import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.common.onTextChanged
import com.enzoftware.projects.di.registerPresenter
import com.enzoftware.projects.ui.base.BaseActivity
import com.enzoftware.projects.ui.register.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterView {

    private val presenter by lazy { registerPresenter() }

    override fun onRegisterSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showSignUpError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showUsernameError() {
        usernameInput.error = getString(R.string.username_error)
    }

    override fun showEmailError() {
        emailInput.error = getString(R.string.email_error)
    }

    override fun showPasswordError() {
        passwordInput.error = getString(R.string.password_error)
    }

    override fun showPasswordMatchingError() {
        repeatPasswordInput.error = getString(R.string.repeat_password_error)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        usernameInput.onTextChanged { presenter.onUsernameChanged(it!!) }
        passwordInput.onTextChanged { presenter.onPasswordChanged(it!!) }
        emailInput.onTextChanged { presenter.onEmailChanged(it!!) }
        repeatPasswordInput.onTextChanged { presenter.onRepeatPasswordChanged(it!!) }

        registerButton.setOnClickListener {
            presenter.onRegisterClicked()
        }
    }
}
