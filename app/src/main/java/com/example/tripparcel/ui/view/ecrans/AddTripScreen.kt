package com.example.tripparcel.ui.view.ecrans

import BottomNavigationBar
import HomeViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tripparcel.ui.view.composants.TopBar


@Composable
fun AddTripScreen(navController: NavController, viewModel: HomeViewModel) {
    // val homeText by viewModel.errorText.collectAsState()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(modifier = Modifier.padding(padding)) {
                ErrorPage()
            }
        },
        modifier = Modifier.background(Color.White)
    )
}
