package com.enzoftware.projects.firebase.database

import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.model.UserEntity

interface FirebaseDatabaseInterface {
    fun listenToQuotes(onResult: (QuoteEntity) -> Unit)
    fun addNewQuote(quoteEntity: QuoteEntity, onResult: (Boolean) -> Unit)
    fun getFavoritesQuotes(userId: String, onResult: (List<QuoteEntity>) -> Unit)
    fun changeQuoteFavoriteStatus(userId: String, quoteEntity: QuoteEntity)
    fun createUser(id: String, email: String, username: String)
    fun getProfile(id: String, onResult: (UserEntity) -> Unit)
}