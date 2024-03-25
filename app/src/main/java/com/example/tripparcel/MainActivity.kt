package com.example.tripparcel

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.tripparcel.ui.login.LoginScreen
import com.example.tripparcel.ui.signup.SignUpScreen
import com.example.tripparcel.ui.theme.TripParcelTheme
import com.example.tripparcel.viewmodel.HomeViewModel
import com.example.tripparcel.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripParcelTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        val viewModel = it.sharedViewModel<HomeViewModel>(navController)
                        HomeScreen(navController = navController,viewModel)
                    }
                    navigation(
                        startDestination = "login",
                        route = "auth"
                    ) {
                        composable("login") {
                            val viewModel = it.sharedViewModel<LoginViewModel>(navController)

                            Button(onClick = {
                                navController.navigate("calendar") {
                                    popUpTo("auth") {
                                        inclusive = true
                                    }
                                }
                            }) {

                            }
                        }
                        composable("register") {
                            val viewModel = it.sharedViewModel<LoginViewModel>(navController)
                        }
                        composable("forgot_password") {
                            val viewModel = it.sharedViewModel<LoginViewModel>(navController)
                        }
                    }
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyNavigation(navController)
                }
            }
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

