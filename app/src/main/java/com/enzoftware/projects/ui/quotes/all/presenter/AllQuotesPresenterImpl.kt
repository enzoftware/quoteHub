package com.enzoftware.projects.ui.quotes.all.presenter

import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.firebase.database.FirebaseDatabaseInterface
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.quotes.all.view.AllQuotesView
import javax.inject.Inject

class AllQuotesPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : AllQuotesPresenter {

    private lateinit var view: AllQuotesView

    override fun viewReady() {
        getAllQuotes()
    }

    override fun getAllQuotes() {
        databaseInterface.listenToQuotes { view.addQuote(it) }
    }

    override fun onFavoriteButtonTapped(quote: QuoteEntity) {
        databaseInterface.changeQuoteFavoriteStatus(authenticationInterface.getUserId(), quote)
    }

    override fun setView(view: AllQuotesView) {
        this.view = view
    }


}