package com.example.s.firebaseauthenticationtest

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.s.firebaseauthenticationtest.ui.screen.ConfirmScreen
import com.example.s.firebaseauthenticationtest.ui.screen.LoginScreen
import com.example.s.firebaseauthenticationtest.ui.screen.SignUpScreen

@Composable
fun FbaNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = LOGIN_SCREEN,
        modifier = modifier
    ) {
        composable(route = LOGIN_SCREEN) {
            LoginScreen(
                navigateConfirm = {
                    navController.navigateSingleTopTo(CONFIRM_SCREEN)
                },
                navigateSignUp = {
                    navController.navigateSingleTopTo(SIGN_UP_SCREEN)
                }
            )
        }
        composable(route = SIGN_UP_SCREEN) {
            SignUpScreen(
                navigateLogin = {
                    navController.navigateSingleTopTo(LOGIN_SCREEN)
                }
            )
        }
        composable(route = CONFIRM_SCREEN) {
            ConfirmScreen(
                onClickBack = {
                    navController.navigateSingleTopTo(LOGIN_SCREEN)
                }
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }
