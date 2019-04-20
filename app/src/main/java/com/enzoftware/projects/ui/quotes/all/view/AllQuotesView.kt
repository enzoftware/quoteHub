package com.enzoftware.projects.ui.quotes.all.view

import com.enzoftware.projects.model.QuoteEntity

interface AllQuotesView {

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun addQuote(quote: QuoteEntity)

    fun setFavoriteQuoteIds(favoriteQuotesIds: List<String>)

}