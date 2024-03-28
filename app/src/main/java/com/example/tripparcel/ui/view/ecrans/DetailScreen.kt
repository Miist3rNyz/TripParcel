package com.example.tripparcel.ui.view.ecrans

import BottomNavigationBar
import ChipList
import HomeViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tripparcel.R
import com.example.tripparcel.ui.view.composants.GradientButton
import com.example.tripparcel.ui.view.composants.TableScreen
import com.example.tripparcel.ui.view.composants.TopBar

@Composable
fun DetailScreen(navController: NavController, viewModel: HomeViewModel) {
    Scaffold(
        topBar = { TopBar() },

        content = { padding -> // We have to pass the scaffold inner padding to our content. That's why we use Box.

            Column(
                verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .background(Color.White.copy(alpha = 0.9f))
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Box(modifier = Modifier.padding(top = 60.dp, start = 16.dp, end = 16.dp)) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(R.drawable.avatar),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(CircleShape)
                                    .border(2.dp, Color.Gray, CircleShape)
                            )
                            Column(modifier = Modifier.padding(5.dp)) {

                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("Nom")
                                    Icon(
                                        painter = painterResource(R.drawable.outline_verified_24),
                                        modifier = Modifier
                                            .padding(horizontal = 5.dp)
                                            .size(13.dp),
                                        contentDescription = "avatar",
                                        tint = Color.Red.copy(alpha = 0.9f)
                                    )
                                }
                                Text("Delaadem")

                            }
                        }
                        Spacer(modifier = Modifier.size(8.dp))
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_calendar_month_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(end = 5.dp)
                                )
                                Text("Dim. 23 Sept 2024")
                            }

                            Icon(
                                painter = painterResource(R.drawable.outline_double_arrow_24),
                                contentDescription = "",
                                tint = Color(0xffd02d27).copy(alpha = 0.9f)
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_calendar_month_24),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(end = 5.dp)
                                )
                                Text("Dim. 23 Sept 2024")
                            }

                        }
                        Spacer(modifier = Modifier.size(5.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_double_arrow_24),
                                    contentDescription = "",
                                    tint = Color(0xffd02d27).copy(alpha = 0.9f),
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(end = 5.dp)

                                )
                                Text("France , Paris")
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("25")
                                Text("$/Kg")
                                Icon(
                                    painter = painterResource(R.drawable.outline_money_24),
                                    contentDescription = "",
                                    tint = Color.Black.copy(alpha = 0.9f), modifier = Modifier
                                        .size(20.dp)
                                        .padding(start = 5.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(5.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_double_arrow_24),
                                    contentDescription = "",
                                    tint = Color.Green.copy(alpha = 0.9f), modifier = Modifier
                                        .size(20.dp)
                                        .padding(end = 5.dp)
                                )
                                Text("France , Paris")
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("France , Paris")
                                Icon(
                                    painter = painterResource(R.drawable.outline_luggage_24),
                                    contentDescription = "",
                                    tint = Color.Black.copy(alpha = 0.9f), modifier = Modifier
                                        .size(20.dp)
                                        .padding(start = 5.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.size(5.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_directions_car_24),
                                    contentDescription = "",
                                    tint = Color.Black.copy(alpha = 0.9f), modifier = Modifier
                                        .size(20.dp)
                                        .padding(end = 5.dp)
                                )
                                Text("Maritime")
                            }
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text("Disponible")
                            }
                        }
                        Spacer(modifier = Modifier.size(15.6.dp))
                        Divider()
                        Spacer(modifier = Modifier.size(15.6.dp))
                        Text(
                            "Recapitulatif",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.size(9.6.dp))
                        val columnData = listOf(
                            "Depart" to listOf("Item A"),
                            "Arrivé" to listOf("Value X"),// Nom de la colonne 3 et ses données
                            "Prix" to listOf("25 $/KG"),

                            )
                        TableScreen(columnData)
                        Text(
                            "Produits autorisés",
                            color = Color.Black,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.size(15.6.dp))
                        ChipList(listOf("Documents", "Livres", "Sac", "bijoux"))
                        Spacer(modifier = Modifier.size(15.6.dp))
                        Divider()
                        Spacer(modifier = Modifier.size(5.dp))

                    }
                }
                val cornerRadius = 0.dp
                val gradientColor = listOf(Color(0xFFd12c29), Color(0xFF6D0824))
                GradientButton(
                    onClick = {},
                    gradientColors = gradientColor,
                    cornerRadius = cornerRadius,
                    nameButton = "Reserver ce voyage",
                    fillMaxWidth = true,
                    heigth = 60.dp,
                    padding = PaddingValues(0.dp),
                    roundedCornerShape = RoundedCornerShape(0.dp)
                )
            }
        })

}



