package com.enzoftware.projects.model

data class UserEntityResponse(
    val id: String = "",
    val username: String = "",
    val password: String = "",
    val quotes: List<QuoteEntity> = listOf()
)


data class UserEntity(
    val id: String,
    val username: String,
    val password: String,
    val quotes: List<QuoteEntity> = listOf()
)