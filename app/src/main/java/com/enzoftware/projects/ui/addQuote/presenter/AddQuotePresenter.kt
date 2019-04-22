package com.enzoftware.projects.ui.addQuote.presenter

import com.enzoftware.projects.ui.addQuote.view.AddQuoteView
import com.enzoftware.projects.ui.base.BasePresenter

interface AddQuotePresenter : BasePresenter<AddQuoteView> {

    fun addQuote()

    fun onQuoteTextChanged(quoteText: String)

}