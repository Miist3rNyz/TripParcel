package com.example.tripparcel.ui.view.ecrans

import BottomNavigationBar
import HomeViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.boltuix.emptystate.screens.NoNotification
import com.example.tripparcel.ui.view.composants.TopBar

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun NotificatonScreen(navController: NavController, viewModel: HomeViewModel) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.
            Box(
                modifier = Modifier
                    .padding(padding)
            ) {
                NoNotification()
            }
        })
        }
