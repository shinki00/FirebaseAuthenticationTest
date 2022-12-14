package com.example.s.firebaseauthenticationtest.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s.firebaseauthenticationtest.seivice.AccountService
import com.example.s.firebaseauthenticationtest.seivice.AccountServiceImpl
import com.example.s.firebaseauthenticationtest.ui.common.isValidEmail
import com.example.s.firebaseauthenticationtest.ui.common.isValidPassword
import com.example.s.firebaseauthenticationtest.ui.common.passwordMatches
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

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

    fun onRepeatPasswordChange(newValue: String) {
        _uiState.value = _uiState.value.copy(repeatPassword = newValue)
    }

    fun onSignUpClick(navigateLogin: () -> Unit) {
        if (!email.isValidEmail()) {
            // エラー表示処理
            return
        }

        if (!password.isValidPassword()) {
            // エラー表示処理
            return
        }

        if (!password.passwordMatches(uiState.value.repeatPassword)) {
            // エラー表示処理
            return
        }

        val accountService: AccountService = AccountServiceImpl()

        viewModelScope.launch {
            // エラーハンドリング処理
            accountService.createUserWithEmailAndPassword(email, password)
            navigateLogin()
        }
    }
}