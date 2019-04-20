package com.enzoftware.projects.model

import com.enzoftware.projects.common.arePasswordsSame
import com.enzoftware.projects.common.isEmailValid
import com.enzoftware.projects.common.isUsernameValid

data class RegisterModel(
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var repeatPassword: String = ""
) {
    fun isValid(): Boolean = isUsernameValid(username)
            && isEmailValid(email)
            && arePasswordsSame(password, repeatPassword)
}