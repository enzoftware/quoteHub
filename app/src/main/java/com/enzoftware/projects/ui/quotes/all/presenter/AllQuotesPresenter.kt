package com.enzoftware.projects.ui.quotes.all.presenter

import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.base.BasePresenter
import com.enzoftware.projects.ui.quotes.all.view.AllQuotesView

interface AllQuotesPresenter : BasePresenter<AllQuotesView> {

    fun viewReady()

    fun getAllJokes()

    fun onFavoriteButtonTapped(quote: QuoteEntity)

}