package com.example.tripparcel.ui.view.composants


import android.graphics.drawable.shapes.RectShape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GradientButton(
    gradientColors: List<Color>,
    cornerRadius: Dp = 25.dp,
    nameButton: String,
    heigth: Dp = 50.dp,
    width: Dp = 200.dp,
    textSize: TextUnit = 20.sp,
    fillMaxWidth: Boolean,
    padding: PaddingValues = PaddingValues(5.dp),
    roundedCornerShape: RoundedCornerShape,
    onClick: () -> Unit,
) {

    Button(
        modifier = Modifier
            //.fillMaxWidth()
            // .then(if (fillMaxWidth) Modifier.fillMaxWidth() else Modifier)
            .padding(padding),
        onClick = onClick,
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(cornerRadius)
    ) {

        Box(
            modifier = Modifier
                .height(heigth)
                // .fillMaxWidth()
                .then(if (fillMaxWidth) Modifier.fillMaxWidth() else Modifier.width(width))
                .background(
                    brush = Brush.horizontalGradient(colors = gradientColors),
                    shape = roundedCornerShape
                )
                .clip(roundedCornerShape)
                /*.background(
                    brush = Brush.linearGradient(colors = gradientColors),
                    shape = RoundedCornerShape(cornerRadius)
                )*/
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = nameButton,
                fontSize = textSize,
                color = Color.White
            )
        }
    }
}
