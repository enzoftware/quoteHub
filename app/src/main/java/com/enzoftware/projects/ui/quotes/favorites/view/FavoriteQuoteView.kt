package com.enzoftware.projects.ui.quotes.favorites.view

import com.enzoftware.projects.model.QuoteEntity

interface FavoriteQuoteView {

    fun showFavoriteQuotes(quotes: List<QuoteEntity>)

    fun clearItems()

    fun showNoDataDescription()

    fun hideNoDataDescription()

}