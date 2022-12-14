package com.example.s.firebaseauthenticationtest.ui.screen

import androidx.compose.foundation.layout.*
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
import com.example.s.firebaseauthenticationtest.ui.common.RepeatPasswordTextField

@Composable
private fun SignUpButton(navigateLogin: () -> Unit, viewModel: SignUpViewModel) {
    OutlinedButton(
        onClick = { viewModel.onSignUpClick(navigateLogin) }, modifier = Modifier.fillMaxWidth()
    ) {

        Text("会員登録")
    }
}

@Composable
fun SignUpScreen(navigateLogin: () -> Unit, viewModel: SignUpViewModel = viewModel()) {

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
        PasswordTextField(
            uiState.password,
            "パスワード",
            viewModel::onPasswordChange,
            Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(12.dp))
        RepeatPasswordTextField(
            uiState.repeatPassword,
            viewModel::onRepeatPasswordChange,
            Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(24.dp))
        SignUpButton(navigateLogin, viewModel)
    }
}
