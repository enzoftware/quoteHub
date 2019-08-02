package com.enzoftware.projects.ui.addQuote

import android.os.Bundle
import com.enzoftware.projects.R
import com.enzoftware.projects.addQuotePresenter
import com.enzoftware.projects.common.onTextChanged
import com.enzoftware.projects.common.showGeneralError
import com.enzoftware.projects.ui.addQuote.view.AddQuoteView
import com.enzoftware.projects.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_add_quote.*

class AddQuoteActivity : BaseActivity(), AddQuoteView {

    private val presenter by lazy { addQuotePresenter() }

    override fun onQuoteAdd() = finish()

    override fun showAddQuoteError() = showGeneralError(this)

    override fun showQouteError() {
        quoteDescription.error = getString(R.string.quote_error)
    }

    override fun removeQuoteError() {
        quoteDescription.error = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quote)
        presenter.setView(this)
        initUi()
    }

    private fun initUi() {
        quoteDescription.onTextChanged {
            presenter.onQuoteTextChanged(it!!)
        }
        addQuote.setOnClickListener {
            presenter.addQuote()
        }
    }
}
