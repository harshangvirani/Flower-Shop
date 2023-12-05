package com.app.flowerui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.flowerui.presentation.ForgotpasswordScreen
import com.app.flowerui.presentation.HomeScreen
import com.app.flowerui.presentation.LoginScreen
import com.app.flowerui.presentation.PopularFlowerScreen
import com.app.flowerui.presentation.SignupScreen
import com.app.flowerui.presentation.SplashScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screens.SplashScreen.routes){
        composable(Screens.SplashScreen.routes){
            SplashScreen(navController)
        }
        composable(Screens.LoginScreen.routes){
            LoginScreen(navController)
        }
        composable(Screens.SignUpScreen.routes){
            SignupScreen(navController)
        }
        composable(Screens.ForgotPasswordScreen.routes){
            ForgotpasswordScreen(navController)
        }
        composable(Screens.HomeScreen.routes){
            HomeScreen(navController)
        }
        composable(Screens.PopularFlowersScreen.routes){
            PopularFlowerScreen(navController)
        }
    }
}