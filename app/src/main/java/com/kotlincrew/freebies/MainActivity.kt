package com.kotlincrew.freebies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kotlincrew.freebies.auth.presentation.login.LoginScreen
import com.kotlincrew.freebies.auth.presentation.login.LoginViewModel
import com.kotlincrew.freebies.navigation.NavigationHost
import com.kotlincrew.freebies.navigation.NavigationRoute
import com.kotlincrew.freebies.ui.theme.FreebiesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreebiesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationHost(
                        navHostController = navController,
                        startDestination = NavigationRoute.Login
                    )
                }
            }
        }
    }
}