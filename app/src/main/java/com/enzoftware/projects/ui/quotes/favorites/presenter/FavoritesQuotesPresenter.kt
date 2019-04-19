package com.enzoftware.projects.ui.quotes.favorites.presenter

import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.base.BasePresenter
import com.enzoftware.projects.ui.quotes.favorites.view.FavoriteQuoteView

interface FavoritesQuotesPresenter : BasePresenter<FavoriteQuoteView> {

    fun getFavoritesQuotes()

    fun onFavoriteButtonTapped(quote: QuoteEntity)

}