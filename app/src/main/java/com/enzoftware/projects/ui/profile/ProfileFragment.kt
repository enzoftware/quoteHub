package com.enzoftware.projects.ui.profile


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enzoftware.projects.R
import com.enzoftware.projects.profilePresenter
import com.enzoftware.projects.ui.base.BaseFragment
import com.enzoftware.projects.ui.profile.view.ProfileView
import com.enzoftware.projects.ui.welcome.WelcomeActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseFragment(), ProfileView {

    private val presenter by lazy { profilePresenter() }

    override fun showUsername(username: String) {
        userName.text = username
    }

    override fun showEmail(email: String) {
        userEmail.text = email
    }

    override fun showNumberOfQuotes(quotes: Int) {
        numberOfQuotes.text = quotes.toString()
    }

    override fun openWelcome() {
        startActivity(Intent(activity, WelcomeActivity::class.java))
        activity?.finish()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        initUi()
        presenter.getProfile()
    }

    private fun initUi() {
        logoutButton.setOnClickListener {
            presenter.logout()
        }
    }
}
