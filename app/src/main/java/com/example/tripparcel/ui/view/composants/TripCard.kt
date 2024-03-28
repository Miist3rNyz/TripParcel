package com.example.tripparcel.ui.view.composants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tripparcel.R
import com.example.tripparcel.model.TripModel


@Composable
fun TripCard(tripModel: TripModel) {
        Column(verticalArrangement = Arrangement.Center) {
            Row (  verticalAlignment = Alignment.CenterVertically,){
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

                    Row( verticalAlignment = Alignment.CenterVertically) {
                        Text(tripModel.name,  style = MaterialTheme.typography.labelMedium,)
                        Icon(
                            painter = painterResource(R.drawable.outline_verified_24),
                            modifier = Modifier
                                .padding(horizontal = 5.dp)
                                .size(13.dp),
                            contentDescription = "avatar",
                            tint = Color.Red.copy(alpha = 0.9f)
                        )
                    }
                    Text(tripModel.firstname,style = MaterialTheme.typography.labelMedium)

                }
            }
            Spacer(modifier = Modifier.size(5.dp))
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
                            .size(20.dp).padding(end = 5.dp)
                    )
                    Text("Dim. 23 Sept 2024",style = MaterialTheme.typography.bodyMedium)
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
                            .size(20.dp).padding(end = 5.dp)
                    )
                    Text("Dim. 23 Sept 2024",style = MaterialTheme.typography.bodyMedium)
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
                            .size(20.dp).padding(end = 5.dp)

                    )
                    Text("France , Paris",style = MaterialTheme.typography.bodyMedium)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("25",style = MaterialTheme.typography.bodyMedium)
                    Text("$/Kg",style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                    Icon(
                        painter = painterResource(R.drawable.outline_money_24),
                        contentDescription = "",
                        tint = Color.Black.copy(alpha = 0.9f), modifier = Modifier
                            .size(20.dp).padding(start = 5.dp)
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
                            .size(20.dp).padding(end = 5.dp)
                    )
                    Text("France , Paris",style = MaterialTheme.typography.bodyMedium)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("France , Paris",style = MaterialTheme.typography.bodyMedium)
                    Icon(
                        painter = painterResource(R.drawable.outline_luggage_24),
                        contentDescription = "",
                        tint = Color.Black.copy(alpha = 0.9f), modifier = Modifier
                            .size(20.dp).padding(start = 5.dp)
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
                            .size(20.dp).padding(end = 5.dp)
                    )
                    Text("Maritime",style = MaterialTheme.typography.bodyMedium,fontWeight = FontWeight.Bold,)
                }

                    Box(
                        modifier = Modifier
                            .background(color = Color(0xFF6D0824), shape = RoundedCornerShape(2.dp))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                    Text("Indisponible",style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Divider(color = Color.Gray.copy(alpha = 0.2f))

        }
    }




