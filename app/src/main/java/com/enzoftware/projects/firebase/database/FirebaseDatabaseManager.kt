package com.enzoftware.projects.firebase.database

import com.enzoftware.projects.model.*
import com.google.firebase.database.*
import javax.inject.Inject

private const val KEY_USER = "user"
private const val KEY_QUOTE = "quote"
private const val KEY_FAV = "favorite"


class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) : FirebaseDatabaseInterface {

    override fun listenToQuotes(onResult: (QuoteEntity) -> Unit) {
        database.reference.child(KEY_QUOTE)
            .orderByKey()
            .addChildEventListener(object : ChildEventListener{
                override fun onCancelled(p0: DatabaseError) = Unit
                override fun onChildMoved(p0: DataSnapshot, p1: String?) = Unit
                override fun onChildChanged(p0: DataSnapshot, p1: String?) = Unit
                override fun onChildRemoved(p0: DataSnapshot) = Unit
                override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
                    snapshot.getValue(QuoteResponse::class.java)?.run {
                        if(isValid()){
                            onResult(mapToQuote())
                        }
                    }
                }
            })
    }

    override fun addNewQuote(quoteEntity: QuoteEntity, onResult: (Boolean) -> Unit) {
        val newQuoteReference = database.reference.child(KEY_QUOTE).push()
        val newQuote = quoteEntity.copy(id = newQuoteReference.key!!)
        newQuoteReference.setValue(newQuote).addOnCompleteListener {
            onResult(it.isSuccessful && it.isComplete)
        }
    }

    override fun getFavoritesQuotes(userId: String, onResult: (List<QuoteEntity>) -> Unit) {
        database.reference
            .child(KEY_USER)
            .child(userId)
            .child(KEY_FAV)
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) = onResult(listOf())

                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.run {
                        val jokes = children.mapNotNull { it.getValue(QuoteResponse::class.java) }
                        onResult(jokes.map(QuoteResponse::mapToQuote))
                    }
                }
            })
    }

    override fun changeQuoteFavoriteStatus(userId: String, quoteEntity: QuoteEntity) {
        val reference = database.reference
            .child(KEY_USER)
            .child(userId)
            .child(KEY_FAV)
            .child(quoteEntity.id)

        reference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {}
            override fun onDataChange(snapshot: DataSnapshot) {
                val oldQuote = snapshot.getValue(QuoteResponse::class.java)
                if (oldQuote != null) {
                    reference.setValue(null)
                } else {
                    reference.setValue(quoteEntity)
                }
            }
        })
    }

    override fun createUser(id: String, email: String, username: String) {
        val user = UserEntity(id, email, username)
        database.reference.child(KEY_USER).child(id).setValue(user)
    }

    override fun getProfile(id: String, onResult: (UserEntity) -> Unit) {
        database.reference
            .child(KEY_USER)
            .child(id)
            .addValueEventListener(object : ValueEventListener{
                override fun onCancelled(p0: DatabaseError) = Unit
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue(UserEntityResponse::class.java)
                    val favoritesJokes = snapshot.child(KEY_FAV).children
                        .map { it.getValue(QuoteResponse::class.java) }
                        .mapNotNull { it?.mapToQuote() }
                    user?.run {
                        onResult(UserEntity(id, username, email, favoritesJokes))
                    }
                }
            })
    }

}