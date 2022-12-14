package com.example.s.firebaseauthenticationtest.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.s.firebaseauthenticationtest.ui.common.EmailTextField
import com.example.s.firebaseauthenticationtest.ui.common.PasswordTextField


@Composable
private fun LoginButton(navigateConfirm: () -> Unit, viewModel: LoginViewModel) {
    Button(
        onClick = { viewModel.onLoginClick(navigateConfirm) }, modifier = Modifier.fillMaxWidth()
    ) {

        Text("ログイン")
    }
}

@Composable
private fun SignUpButton(navigateSignUp: () -> Unit = {}) {
    OutlinedButton(
        onClick = navigateSignUp, modifier = Modifier.fillMaxWidth()
    ) {

        Text("会員登録へ")
    }
}

@Composable
fun LoginScreen(
    navigateConfirm: () -> Unit = {},
    navigateSignUp: () -> Unit = {},
    viewModel: LoginViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        EmailTextField(uiState.email, viewModel::onEmailChange, Modifier.fillMaxWidth())
        Spacer(Modifier.height(12.dp))
        PasswordTextField(uiState.password, "パスワード", viewModel::onPasswordChange, Modifier.fillMaxWidth())
        Spacer(Modifier.height(24.dp))
        LoginButton(navigateConfirm, viewModel)
        Spacer(Modifier.height(12.dp))
        SignUpButton(navigateSignUp)
    }
}
