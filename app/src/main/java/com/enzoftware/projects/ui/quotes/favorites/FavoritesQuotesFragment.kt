package com.enzoftware.projects.ui.quotes.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.enzoftware.projects.R
import com.enzoftware.projects.favoriteQuotesPresenter
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.base.BaseFragment
import com.enzoftware.projects.ui.quotes.all.list.FavoriteQuoteAdapter
import com.enzoftware.projects.ui.quotes.favorites.view.FavoriteQuoteView
import kotlinx.android.synthetic.main.fragment_quotes.*

class FavoritesQuotesFragment : BaseFragment(), FavoriteQuoteView {

    private val presenter by lazy { favoriteQuotesPresenter() }
    private val adapter by lazy { FavoriteQuoteAdapter(presenter::onFavoriteButtonTapped) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setView(this)
        initUi()
        presenter.getFavoritesQuotes()
    }

    private fun initUi() {
        quotes.layoutManager = LinearLayoutManager(activity)
        quotes.setHasFixedSize(true)
        quotes.adapter = adapter
    }

    override fun showFavoriteQuotes(quotes: List<QuoteEntity>) = adapter.setData(quotes)

    override fun clearItems() = adapter.clear()

    override fun showNoDataDescription() {
        noItems.visibility = View.VISIBLE
    }

    override fun hideNoDataDescription() {
        noItems.visibility = View.INVISIBLE
    }


}