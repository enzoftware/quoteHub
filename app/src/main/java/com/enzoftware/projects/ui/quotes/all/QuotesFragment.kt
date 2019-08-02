package com.enzoftware.projects.ui.quotes.all


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.enzoftware.projects.R
import com.enzoftware.projects.allQuotesPresenter
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.base.BaseFragment
import com.enzoftware.projects.ui.quotes.all.view.AllQuotesView
import com.enzoftware.projects.ui.quotes.favorites.list.QuoteAdapter
import kotlinx.android.synthetic.main.fragment_quotes.*


class QuotesFragment : BaseFragment(), AllQuotesView {


    private val presenter by lazy { allQuotesPresenter() }
    private val adapter by lazy { QuoteAdapter(presenter::onFavoriteButtonTapped) }


    override fun showNoDataDescription() {
        noItems.visibility = View.VISIBLE
    }

    override fun hideNoDataDescription() {
        noItems.visibility = View.GONE
    }

    override fun addQuote(quote: QuoteEntity) {
        adapter.addQuote(quote)
        noItems.visibility = if (adapter.itemCount != 0) View.INVISIBLE else View.VISIBLE
    }

    override fun setFavoriteQuoteIds(favoriteQuotesIds: List<String>) {
        adapter.setFavoritesQuotesIds(favoriteQuotesIds)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        presenter.setView(this)
        presenter.viewReady()
    }

    private fun initUi() {
        quotes.layoutManager = LinearLayoutManager(activity)
        quotes.setHasFixedSize(true)
        quotes.adapter = adapter
    }


}
