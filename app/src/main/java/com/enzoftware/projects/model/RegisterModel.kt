package com.enzoftware.projects.model

data class RegisterModel(
    val username: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val email: String = ""
)