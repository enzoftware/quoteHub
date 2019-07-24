package com.enzoftware.projects.model

data class QuoteEntity(
    val id: String,
    val authorName: String,
    val authorId: String,
    val text: String,
    var isFavorite: Boolean = false
)


data class QuoteResponse(val id: String = "",
                        val authorName: String = "",
                        val authorId: String = "",
                        val text: String = "")

fun QuoteResponse.isValid() = id.isNotBlank()
        && authorName.isNotBlank()
        && authorId.isNotBlank()
        && text.isNotBlank()

fun QuoteResponse.mapToQuote() = QuoteEntity(id, authorName, authorId, text)