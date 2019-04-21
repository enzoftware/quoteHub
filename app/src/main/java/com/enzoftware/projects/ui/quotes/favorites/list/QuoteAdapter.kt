package com.enzoftware.projects.ui.quotes.favorites.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enzoftware.projects.R
import com.enzoftware.projects.model.QuoteEntity

class QuoteAdapter(private val onFavoriteClickHandler: (QuoteEntity) -> Unit) : RecyclerView.Adapter<QuoteHolder>() {

    private val items = mutableListOf<QuoteEntity>()
    private val favoriteQuotesIds = mutableListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        return QuoteHolder(view, onFavoriteClickHandler)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) {
        val quote = items[position].apply {
            isFavorite = id in favoriteQuotesIds
        }

        holder.displayData(quote)
    }

    fun addQuote(quote: QuoteEntity) {
        items.add(quote)
        notifyItemInserted(items.size - 1)
    }

    fun setFavoritesQuotesIds(ids: List<String>) {
        favoriteQuotesIds.clear()
        favoriteQuotesIds.addAll(ids)
        notifyDataSetChanged()
    }

}