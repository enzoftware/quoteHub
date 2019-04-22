package com.enzoftware.projects.ui.quotes.favorites.presenter

import com.enzoftware.projects.firebase.authentication.FirebaseAuthenticationInterface
import com.enzoftware.projects.firebase.database.FirebaseDatabaseInterface
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.quotes.favorites.view.FavoriteQuoteView
import javax.inject.Inject

class FavoritesQuotesPresenterImpl @Inject constructor(
    private val databaseInterface: FirebaseDatabaseInterface,
    private val authenticationInterface: FirebaseAuthenticationInterface
) : FavoritesQuotesPresenter {

    private lateinit var view: FavoriteQuoteView

    override fun getFavoritesQuotes() {
        val id = authenticationInterface.getUserId()

        databaseInterface.getFavoritesQuotes(id) {
            it.forEach {
                it.isFavorite = true
            }
            displayItems(it)
        }
    }

    override fun onFavoriteButtonTapped(quote: QuoteEntity) {
        databaseInterface.changeQuoteFavoriteStatus(authenticationInterface.getUserId(), quote)
    }

    override fun setView(view: FavoriteQuoteView) {
        this.view = view
    }

    private fun displayItems(items: List<QuoteEntity>) {
        if (items.isEmpty()) {
            view.clearItems()
            view.showNoDataDescription()
        } else {
            view.hideNoDataDescription()
            view.showFavoriteQuotes(items)
        }
    }

}