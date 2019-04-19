package com.enzoftware.projects.ui.quotes.favorites.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.enzoftware.projects.R
import com.enzoftware.projects.common.onClick
import com.enzoftware.projects.model.QuoteEntity
import kotlinx.android.synthetic.main.item_quote.view.*

class QuoteHolder(
    itemView: View,
    private inline val onFavoriteClickHandler: (QuoteEntity) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun displayData(quote: QuoteEntity) = with(itemView) {
        favoriteButton.onClick { onFavoriteClickHandler(quote) }

        quoteAuthor.text = quote.authorName

        quoteDescription.text = quote.text

        favoriteButton.setImageResource(
            if (quote.isFavorite) R.drawable.ic_favorite_border else R.drawable.ic_favorite_filled
        )
    }


}