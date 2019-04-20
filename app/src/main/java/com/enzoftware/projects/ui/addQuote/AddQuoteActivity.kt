package com.enzoftware.projects.ui.addQuote

import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.di.addQuotePresenter
import com.enzoftware.projects.ui.addQuote.view.AddQuoteView
import com.enzoftware.projects.ui.base.BaseActivity

class AddQuoteActivity : BaseActivity(), AddQuoteView {

    private val presenter by lazy { addQuotePresenter() }

    override fun onQuoteAdd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showAddQuoteError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showQouteError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeQuoteError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quote)
    }
}
