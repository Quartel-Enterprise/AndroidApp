package com.blitzsplit.login.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()
    fun onEvent(event: LoginEvent) {
        when(event) {
            is LoginEvent.ChangeTextFieldValue -> {
                _state.value = _state.value.copy(
                    textFieldValue = event.value
                )
            }
        }
    }
}