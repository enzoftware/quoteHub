package com.enzoftware.projects.ui.quotes.all


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enzoftware.projects.R
import com.enzoftware.projects.allQuotesPresenter
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.base.BaseFragment
import com.enzoftware.projects.ui.quotes.all.view.AllQuotesView
import com.enzoftware.projects.ui.quotes.favorites.list.QuoteAdapter


class QuotesFragment : BaseFragment(), AllQuotesView {


    private val presenter by lazy { allQuotesPresenter() }
    private val adapter by lazy { QuoteAdapter(presenter::onFavoriteButtonTapped) }


    override fun showNoDataDescription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideNoDataDescription() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addQuote(quote: QuoteEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setFavoriteQuoteIds(favoriteQuotesIds: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }


}
