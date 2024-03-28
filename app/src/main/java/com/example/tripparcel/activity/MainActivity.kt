package com.example.tripparcel.activity

import HomeScreen
import HomeViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tripparcel.ui.view.ecrans.AddTripScreen
import com.example.tripparcel.ui.view.ecrans.DetailScreen
import com.example.tripparcel.ui.view.ecrans.NotificatonScreen
import com.example.tripparcel.ui.view.ecrans.ProfileScreen
import com.example.tripparcel.utilies.AuthInitializer
import com.example.tripparcel.utilies.FirestoreInitializer

class MainActivity : ComponentActivity() {
    lateinit var firestore: FirestoreInitializer
    lateinit var firebaseAuth:  AuthInitializer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                val navController = rememberNavController()
                Navigation(navController = navController)
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


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Home.route,
        modifier = Modifier.padding(0.dp, 0.dp)
    ) {
        composable(route = NavigationItem.Home.route) {
            val viewModel = it.sharedViewModel<HomeViewModel>(navController)
            HomeScreen(navController, viewModel)
        }

        composable(route = NavigationItem.Add.route) {
            val viewModel = it.sharedViewModel<HomeViewModel>(navController)
            AddTripScreen(navController, viewModel)
        }
        composable(route = NavigationItem.Notification.route) {
            val viewModel = it.sharedViewModel<HomeViewModel>(navController)
            NotificatonScreen(navController, viewModel)
        }
        composable(route = NavigationItem.Profile.route) {
            val viewModel = it.sharedViewModel<HomeViewModel>(navController)
            ProfileScreen(navController, viewModel)
        }
        composable(route = NavigationItem.DetailScreen.route) {
            val viewModel = it.sharedViewModel<HomeViewModel>(navController)
            DetailScreen(navController, viewModel)
        }

    }

}
