package com.enzoftware.projects.ui.quotes.all.view

interface AllQuotesView {

    fun showNoDataDescription()

    fun hideNoDataDescription()

    fun addQuote()

    fun setFavoriteQuoteIds(favoriteQuotesIds: List<String>)

}