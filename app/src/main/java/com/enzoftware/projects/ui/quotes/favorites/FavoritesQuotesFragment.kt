package com.enzoftware.projects.ui.quotes.favorites

import com.enzoftware.projects.favoriteQuotesPresenter
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.base.BaseFragment
import com.enzoftware.projects.ui.quotes.all.list.FavoriteQuoteAdapter
import com.enzoftware.projects.ui.quotes.favorites.view.FavoriteQuoteView

class FavoritesQuotesFragment : BaseFragment(), FavoriteQuoteView {

    private val presenter by lazy { favoriteQuotesPresenter() }
    private val adapter by lazy { FavoriteQuoteAdapter(presenter::onFavoriteButtonTapped) }

    override fun showFavoriteQuotes(quotes: List<QuoteEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearItems() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNoDataDescription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideNoDataDescription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}