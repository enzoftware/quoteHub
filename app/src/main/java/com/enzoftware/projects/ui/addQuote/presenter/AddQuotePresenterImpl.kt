package com.enzoftware.projects.ui.addQuote.presenter

import com.enzoftware.projects.common.isValidQuote
import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.firebase.database.FirebaseDatabaseInterface
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.addQuote.view.AddQuoteView
import javax.inject.Inject

class AddQuotePresenterImpl @Inject constructor(
    private val authenticationInterface: FirebaseAuthenticationInterface,
    private val databaseInterface: FirebaseDatabaseInterface
) : AddQuotePresenter {

    private lateinit var view: AddQuoteView

    private var quoteText: String = ""

    override fun addQuote() {
        if (isValidQuote(quoteText)) {
            val quote =
                QuoteEntity("", authenticationInterface.getUserName(), authenticationInterface.getUserId(), quoteText)
            databaseInterface.addNewQuote(quote) {
                onAddQuoteResult(it)
            }
        }
    }

    override fun onQuoteTextChanged(quoteText: String) {
        this.quoteText = quoteText

        if (!isValidQuote(quoteText)) {
            view.showQouteError()
        } else {
            view.removeQuoteError()
        }
    }

    override fun setView(view: AddQuoteView) {
        this.view = view
    }

    private fun onAddQuoteResult(isSuccess: Boolean) {
        if (isSuccess) {
            view.onQuoteAdd()
        } else {
            view.showAddQuoteError()
        }
    }

}