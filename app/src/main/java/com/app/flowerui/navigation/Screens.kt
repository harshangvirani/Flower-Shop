package com.app.flowerui.navigation

sealed class Screens(val routes: String) {
    object SplashScreen: Screens("splash_screen")
    object LoginScreen: Screens("login_screen")
    object SignUpScreen: Screens("signup_screen")
    object ForgotPasswordScreen: Screens("forgot_password_screen")
    object HomeScreen: Screens("home_screen")
    object PopularFlowersScreen: Screens("popular_flowers_screen")
}