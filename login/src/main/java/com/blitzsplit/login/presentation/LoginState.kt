package com.blitzsplit.login.presentation

data class LoginState(
    val isLoginSuccessful: Boolean = false,
    val loginErrorMessage: String? = null,
    val textFieldValue: String = ""
)