package com.dannndi.authenticationkit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dannndi.authenticationkit.module.forgot_password.ForgotPasswordScreen
import com.dannndi.authenticationkit.module.login.LoginScreen
import com.dannndi.authenticationkit.module.register.RegisterScreen
import com.dannndi.authenticationkit.module.reset_password.ResetPasswordScreen
import com.dannndi.authenticationkit.ui.theme.AuthenticationKitTheme

const val LOGIN_ROUTE = "/login"
const val REGISTER_ROUTE = "/register"
const val FORGOT_PASSWORD_ROUTE = "/forgot-password"
const val RESET_PASSWORD_ROUTE = "/reset_password"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            AuthenticationKitTheme {
                NavHost(navController = navController, startDestination = LOGIN_ROUTE){
                    composable(LOGIN_ROUTE){ LoginScreen(navController) }
                    composable(REGISTER_ROUTE){ RegisterScreen(navController) }
                    composable(FORGOT_PASSWORD_ROUTE){ ForgotPasswordScreen(navController) }
                    composable(RESET_PASSWORD_ROUTE){ ResetPasswordScreen(navController) }
                }
            }
        }
    }
}
