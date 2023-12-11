package com.blitzsplit.login.presentation

sealed class LoginEvent {
    class ChangeTextFieldValue(val value: String): LoginEvent()
}