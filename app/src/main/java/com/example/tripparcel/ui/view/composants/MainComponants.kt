package com.example.tripparcel.ui.view.composants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainComponants(text: String, onClick: () -> Unit) {
    Column {
        Text(text = text)
        Button(onClick = onClick) {
            Text(text = "Changer le texte")
        }
    }
}