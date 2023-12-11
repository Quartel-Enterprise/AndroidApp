package com.blitzsplit.login.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginClick: () -> Unit
) {
    val state = viewModel.state.collectAsState()
    val context = LocalContext.current

    val textFieldValue = state.value.textFieldValue
    val loginErrorMessage = state.value.loginErrorMessage

    LaunchedEffect(key1 = loginErrorMessage) {
        loginErrorMessage?.let { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TextField(
            value = textFieldValue,
            onValueChange = {
                viewModel.onEvent(LoginEvent.ChangeTextFieldValue(it))
            }
        )
        Button(onClick =  onLoginClick) {
            Text("Login")
        }
    }
}