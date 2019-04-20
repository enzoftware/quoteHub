package com.enzoftware.projects.ui.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enzoftware.projects.R
import com.enzoftware.projects.di.profilePresenter
import com.enzoftware.projects.ui.base.BaseFragment
import com.enzoftware.projects.ui.profile.view.ProfileView

class ProfileFragment : BaseFragment(), ProfileView {


    private val presenter by lazy { profilePresenter() }

    override fun showUsername(username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmail(email: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNumberOfJokes(jokes: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun openWelcome() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}
