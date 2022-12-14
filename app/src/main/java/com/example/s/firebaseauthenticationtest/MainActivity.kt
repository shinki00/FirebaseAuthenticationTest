package com.example.s.firebaseauthenticationtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.s.firebaseauthenticationtest.ui.theme.FirebaseAuthenticationTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp() {
    FirebaseAuthenticationTestTheme {
        val navController = rememberNavController()
        FbaNavHost(navController = navController)
    }
}