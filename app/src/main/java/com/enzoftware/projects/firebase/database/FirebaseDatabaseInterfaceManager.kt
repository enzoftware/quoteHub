package com.enzoftware.projects.firebase.database

import com.enzoftware.projects.model.QuoteEntity
import com.enzoftware.projects.model.UserEntity

class FirebaseDatabaseInterfaceManager : FirebaseDatabaseInterface {

    override fun listenToQuotes(onResult: (QuoteEntity) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addNewQuote(quoteEntity: QuoteEntity, onResult: (Boolean) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFavoritesQuotes(userId: String, onResult: (List<QuoteEntity>) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun changeQuoteFavoriteStatus(userId: String, quoteEntity: QuoteEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createUser(id: String, email: String, username: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProfile(id: String, onResult: (UserEntity) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}