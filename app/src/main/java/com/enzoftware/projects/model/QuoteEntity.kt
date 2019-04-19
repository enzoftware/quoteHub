package com.enzoftware.projects.model

data class QuoteEntity(
    val id: String,
    val authorName: String,
    val authorId: String,
    val text: String,
    var isFavorite: Boolean
)