package com.enzoftware.projects.firebase.database

import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.model.UserEntity
import javax.inject.Inject

class FirebaseDatabaseManager @Inject constructor() : FirebaseDatabaseInterface {

    override fun listenToQuotes(onResult: (QuoteEntity) -> Unit) {
    }

    override fun addNewQuote(quoteEntity: QuoteEntity, onResult: (Boolean) -> Unit) {
    }

    override fun getFavoritesQuotes(userId: String, onResult: (List<QuoteEntity>) -> Unit) {
    }

    override fun changeQuoteFavoriteStatus(userId: String, quoteEntity: QuoteEntity) {
    }

    override fun createUser(id: String, email: String, username: String) {
    }

    override fun getProfile(id: String, onResult: (UserEntity) -> Unit) {
    }

}