package com.bsrn.dynamic_animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch

enum class IconState {
    EXPANDED, DEFAULT
}

@Composable
fun DynamicAnimation(
    modifier: Modifier,
    iconPathData: String,
    onClick: () -> Unit = {},
    startValue: Float = 16f,
    endValue: Float = 32f,
    fillColor: Color = Color.Red,
    strokeColor: Color = Color.Red,
 ) {
    var iconState by remember { mutableStateOf(IconState.DEFAULT) }
    val animatableSize = remember { Animatable(startValue) }
    val animatableFillColor = remember { Animatable(Color.Transparent) }
    val iconPath = remember(iconPathData) { PathParser().parsePathString(iconPathData).toPath() }
    val coroutineScope = rememberCoroutineScope()

    IconButton(
        onClick = {
            coroutineScope.launch {
                if (iconState == IconState.DEFAULT) {
                    animatableFillColor.animateTo(fillColor, tween(durationMillis = 100))
                    animatableSize.animateTo(endValue, tween(durationMillis = 500))
                    iconState = IconState.EXPANDED
                    // Ensure the icon returns to its default size after expanding
                    animatableSize.animateTo(startValue, tween(durationMillis = 500))
                } else {
                    animatableFillColor.animateTo(Color.Transparent, tween(durationMillis = 100))
                    animatableSize.animateTo(startValue, tween(durationMillis = 500))
                    iconState = IconState.DEFAULT
                }
            }
            onClick()
        },
        modifier = modifier
            .size(max(animatableSize.value.dp, (startValue * 6).dp))
            .zIndex(1f)
    ) {
        Canvas(modifier = Modifier.size(animatableSize.value.dp)) {
            val scaleFactor = animatableSize.value / 8f
            val iconBounds = iconPath.getBounds()
            val pivot = Offset(
                iconBounds.left + iconBounds.width / 2,
                iconBounds.top + iconBounds.height / 2
            )
            withTransform({
                scale(scaleFactor, scaleFactor, pivot)
            }) {
                drawPath(path = iconPath, color = animatableFillColor.value)
                drawPath(path = iconPath, color = strokeColor, style = Stroke(width = 1f))
            }
        }
    }
}