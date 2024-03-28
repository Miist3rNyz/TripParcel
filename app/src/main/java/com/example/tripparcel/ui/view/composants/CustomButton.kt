package com.example.tripparcel.ui.view.composants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(onClick: () -> Unit,) {

    Button(onClick = onClick, modifier = Modifier
        .background(Color.Red)
        .height(123.dp)
        .width(150.dp) ) {

    }

}
