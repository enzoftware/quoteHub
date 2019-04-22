package com.enzoftware.projects.ui.quotes.all.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enzoftware.projects.R
import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.ui.quotes.favorites.list.QuoteHolder

class FavoriteQuoteAdapter(
    private val onFavoriteClickHandler: (QuoteEntity) -> Unit
) : RecyclerView.Adapter<QuoteHolder>() {

    private val items = mutableListOf<QuoteEntity>()

    override fun getItemCount() = items.size

    fun setData(data: List<QuoteEntity>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_quote, parent, false)

        return QuoteHolder(view, onFavoriteClickHandler)
    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) = holder.displayData(items[position])

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }
}