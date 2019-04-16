package com.enzoftware.projects.common

const val MIN_CREDENTIAL_LENGTH = 6
const val MIN_JOKE_LENGTH = 10

fun isPasswordValid(password: String) = password.length >= MIN_CREDENTIAL_LENGTH

fun isUsernameValid(username: String) = username.length >= MIN_CREDENTIAL_LENGTH

fun arePasswordsSame(password: String, repeatPassword: String) = isPasswordValid(password) &&
        isPasswordValid(repeatPassword) &&
        password == repeatPassword

fun isValidJoke(jokeText: String) = jokeText.length >= MIN_JOKE_LENGTH