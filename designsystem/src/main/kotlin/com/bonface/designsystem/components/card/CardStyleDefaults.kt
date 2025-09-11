package com.bonface.designsystem.components.card

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.elevations

object CardStyleDefaults {

    @Composable
    @ReadOnlyComposable
    fun default(
        color: Color = MaterialTheme.colorScheme.surface,
        elevation: Dp = MaterialTheme.elevations.max,
        shadowShape: CornerBasedShape = MaterialTheme.shapes.large,
        cardShape: Shape = MaterialTheme.shapes.large,
    ): CardStyle = CardStyle(
        color = color,
        elevation = elevation,
        shadowShape = shadowShape,
        shape = cardShape,
    )

    @Composable
    @ReadOnlyComposable
    fun stroked(
        color: Color = MaterialTheme.colorScheme.surface,
        elevation: Dp = MaterialTheme.elevations.max,
        shadowShape: CornerBasedShape = MaterialTheme.shapes.large,
        strokeColors: List<Color> = listOf(MaterialTheme.customColors.gradientStart, MaterialTheme.customColors.gradientEnd),
    ): CardStyle = CardStyle(
        color = color,
        elevation = elevation,
        shadowShape = shadowShape,
        hasStroke = true,
        strokeColors = strokeColors,
    )
}
