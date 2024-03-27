package com.example.tripparcel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tripparcel.ui.HomeScreen
import com.example.tripparcel.ui.login.LoginScreen
import com.example.tripparcel.ui.signup.PolicyScreen
import com.example.tripparcel.ui.signup.SignUpScreen

sealed class Route{
    data class LoginScreen(val name:String = "Login"):Route()
    data class SignUpScreen(val name:String = "SignUp"):Route()
    data class PolicyScreen(val name:String = "Policy"):Route()
    data class HomeScreen(val name:String = "Home"):Route()
}

@Composable
fun MyNavigation(navHostController: NavHostController){
    NavHost(
        navController = navHostController,
        startDestination = Route.LoginScreen().name,
    ){
        composable(route = Route.LoginScreen().name){
            LoginScreen(
                onLoginClick = {
                   navHostController.navigate(
                       Route.HomeScreen().name
                   )
                },
                onSignUpClick = {
                    navHostController.navigate(
                        Route.SignUpScreen().name
                    )
                }
            )
        }

        composable(route = Route.SignUpScreen().name){
            SignUpScreen(
                onSignUpClick = {
                    navHostController.navigate(
                        Route.HomeScreen().name
                    )
                },
                onLoginClick = {
                    navHostController.navigate(
                        Route.LoginScreen().name
                    )
                },
                onPolicyClick = {
                    navHostController.navigate(
                        Route.PolicyScreen().name
                    )
                }
            )
        }

        composable(route = Route.PolicyScreen().name){
            PolicyScreen {
                navHostController.navigateUp()
            }
        }

        composable(route = Route.HomeScreen().name){
            HomeScreen()
        }
    }
}

fun NavController.navigateToSingleTop(route:String){
    navigate(route){
        popUpTo(graph.findStartDestination().id)
    }
}