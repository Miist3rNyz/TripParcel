package com.example.tripparcel.ui.signup


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PolicyScreen(onBtnClick:()->Unit){
    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
        Column {
            Text(text = "Politique de confidentialité")
            Button(onClick = onBtnClick) {
                Text(text = "Finish")
            }
        }
    }
}