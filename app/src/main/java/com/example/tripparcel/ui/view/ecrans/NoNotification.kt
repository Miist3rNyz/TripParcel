package com.boltuix.emptystate.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tripparcel.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoNotification() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.bell),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth(),

            )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "No Notifications",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            letterSpacing = 2.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "When you have notification, you 'll see them here",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                .fillMaxWidth(),
            letterSpacing = 1.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
        )
    }


}



