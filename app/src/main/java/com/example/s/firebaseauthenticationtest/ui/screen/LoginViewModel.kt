package com.example.s.firebaseauthenticationtest.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s.firebaseauthenticationtest.seivice.AccountService
import com.example.s.firebaseauthenticationtest.seivice.AccountServiceImpl
import com.example.s.firebaseauthenticationtest.ui.common.isValidEmail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password

    fun onEmailChange(newValue: String) {
        _uiState.value = _uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        _uiState.value = _uiState.value.copy(password = newValue)
    }

    fun onLoginClick(navigateLogin: () -> Unit) {

        if (!email.isValidEmail()) {
            // エラー表示処理
            return
        }

        if (password.isBlank()) {
            // エラー表示処理
            return
        }

        val accountService: AccountService = AccountServiceImpl()

        viewModelScope.launch {
            // エラーハンドリング処理
            accountService.authenticate(email, password)
            navigateLogin()
        }
    }

}