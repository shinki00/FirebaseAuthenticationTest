package com.example.s.firebaseauthenticationtest.ui.common

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation


@Composable
fun EmailTextField(value: String, onNewValue: (String) -> Unit, modifier: Modifier = Modifier) {

    OutlinedTextField(
        value = value,
        onValueChange = { onNewValue(it) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
        label = { Text("メールアドレス") },
    )
}

@Composable
fun PasswordTextField(
    value: String,
    label: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onNewValue(it) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
        ),
        visualTransformation = PasswordVisualTransformation(),
        label = { Text(label) },
    )
}

@Composable
fun RepeatPasswordTextField(
    value: String,
    onNewValue: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    PasswordTextField(value, "パスワード確認用", onNewValue, modifier)
}