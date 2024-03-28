package com.example.tripparcel.ui.view.composants

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun ComponentCircle(size: Dp =50.dp) {
    Box(
        modifier = Modifier
            .background(color = Color.LightGray, shape = CircleShape)
            .size(size =size)
            .shimmerLoadingAnimation()
    )
}

@Composable
fun ComponentSquare(size: Dp =50.dp) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color.LightGray)
            .size(size)
            .shimmerLoadingAnimation() // <--- Here.
    )
}

@Composable
fun ComponentRectangle(size: Dp =100.dp) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color.LightGray)
            .height(size)
            .fillMaxWidth()
            .shimmerLoadingAnimation()
    )
}

@Composable
fun ComponentRectangleLineLong(heigth:Dp=15.dp,width: Dp =100.dp) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.LightGray)
            .size(height = heigth, width = width)
            .shimmerLoadingAnimation() // <--- Here.
    )
}

@Composable
fun ComponentRectangleLineShort(heigth:Dp=15.dp,width: Dp =50.dp) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = Color.LightGray)
            .size(height = heigth, width = width)
            .shimmerLoadingAnimation() // <--- Here.
    )
}

fun Modifier.shimmerLoadingAnimation(
    widthOfShadowBrush: Int = 500,
    angleOfAxisY: Float = 270f,
    durationMillis: Int = 1000,
): Modifier {
    return composed {

        val shimmerColors = listOf(
            Color.White.copy(alpha = 0.3f),
            Color.White.copy(alpha = 0.5f),
            Color.White.copy(alpha = 1.0f),
            Color.White.copy(alpha = 0.5f),
            Color.White.copy(alpha = 0.3f),
        )

        val transition = rememberInfiniteTransition(label = "")

        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = durationMillis,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Restart,
            ),
            label = "Shimmer loading animation",
        )

        this.background(
            brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
                end = Offset(x = translateAnimation.value, y = angleOfAxisY),
            ),
        )
    }
}