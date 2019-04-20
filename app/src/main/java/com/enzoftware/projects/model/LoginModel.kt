package com.enzoftware.projects.model

import com.enzoftware.projects.common.isEmailValid
import com.enzoftware.projects.common.isPasswordValid

data class LoginModel(
    var email: String = "",
    var password: String = ""
) {
    fun isValid() = isEmailValid(email) && isPasswordValid(password)
}