package com.kotlincrew.freebies.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kotlincrew.freebies.auth.presentation.login.LoginScreen
import com.kotlincrew.freebies.auth.presentation.signup.SignupScreen

@Composable
fun NavigationHost(
    navHostController: NavHostController, startDestination: NavigationRoute
) {
    NavHost(navController = navHostController, startDestination = startDestination.route) {
        composable(NavigationRoute.Login.route) {
            LoginScreen(onSignUp = {
                navHostController.navigate(NavigationRoute.Signup.route)
            }, onLogin = {
                navHostController.popBackStack()
                navHostController.navigate(NavigationRoute.Home.route)
            })
        }
        composable(NavigationRoute.Home.route) {
            //make a real HomeScreen
            Text(text = "HomeScreen", color = MaterialTheme.colorScheme.secondary)
        }

        composable(NavigationRoute.Signup.route) {
            SignupScreen(onLogin = {
                navHostController.navigate(NavigationRoute.Login.route)
            }, onSignIn = {
                navHostController.navigate(NavigationRoute.Home.route) {
                    popUpTo(navHostController.graph.id) {
                        inclusive = true
                    }
                }
            })
        }
    }
}