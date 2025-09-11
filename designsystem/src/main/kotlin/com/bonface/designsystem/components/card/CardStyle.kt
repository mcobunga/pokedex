package com.bonface.designsystem.components.card

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Card style
 *
 * @property color
 * @property elevation
 * @property shadowShape
 * @property hasStroke
 * @property strokeColors
 */
data class CardStyle(
    val color: Color = Color.Unspecified,
    val elevation: Dp = 0.dp,
    val shadowShape: Shape = RectangleShape,
    val hasStroke: Boolean = false,
    val strokeColors: List<Color>? = null,
    val shape: Shape = RectangleShape,
    @Deprecated(message = "To be removed once deprecated BasicCard's usage has been removed") val brush: Brush? = null,
)
