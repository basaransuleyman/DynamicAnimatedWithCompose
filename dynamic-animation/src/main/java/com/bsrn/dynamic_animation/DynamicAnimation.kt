package com.bsrn.dynamic_animation

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
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
    iconPathData: String,
    onClick: () -> Unit = {},
    startValue: Float = 16f,
    endValue: Float = 32f,
    fillColor: Color = Color.Red,
    strokeColor: Color = Color.Red
) {
    var iconState by remember { mutableStateOf(IconState.DEFAULT) }
    val sizeAnim = remember { Animatable(16f) }
    val fillColorAnim = remember { Animatable(Color.Transparent) }
    val scope = rememberCoroutineScope()
    val iconPath = remember { PathParser().parsePathString(iconPathData).toPath() }

    fun expandIcon() {
        scope.launch {
            fillColorAnim.animateTo(fillColor, tween(durationMillis = 100))
            sizeAnim.animateTo(endValue, tween(durationMillis = 500))
            iconState = IconState.EXPANDED
            sizeAnim.animateTo(startValue, tween(durationMillis = 500))
        }
    }

    fun collapseIcon() {
        scope.launch {
            fillColorAnim.animateTo(Color.Transparent, tween(durationMillis = 100))
            sizeAnim.animateTo(startValue, tween(durationMillis = 500))
            iconState = IconState.DEFAULT
        }
    }

    IconButton(
        onClick = {
            if (iconState == IconState.DEFAULT) {
                expandIcon()
            } else {
                collapseIcon()
            }
            onClick()
        },
        modifier = Modifier
            .size(max(sizeAnim.value.dp, (startValue * 6).dp))
            .zIndex(1f)
    ) {
        Canvas(modifier = Modifier.size(sizeAnim.value.dp)) {
            val scaleFactor = sizeAnim.value / 8f
            val iconBounds = iconPath.getBounds()
            val pivot = Offset(
                iconBounds.left + iconBounds.width / 2,
                iconBounds.top + iconBounds.height / 2
            )

            withTransform({
                scale(scaleFactor, scaleFactor, pivot = pivot)
            }) {
                // Draw the fill color
                drawPath(
                    path = iconPath,
                    color = fillColorAnim.value
                )

                // Draw the stroke
                drawPath(
                    path = iconPath,
                    color = strokeColor,
                    style = Stroke(width = 1f)
                )
            }
        }
    }
}