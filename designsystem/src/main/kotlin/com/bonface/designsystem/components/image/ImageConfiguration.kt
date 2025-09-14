package com.bonface.designsystem.components.image

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale

/**
 * Image configuration
 *
 * @constructor Create empty Image configuration
 * @property aspectRatio
 * @property shape
 * @property contentScale
 * @property contentPadding
 */
data class ImageConfiguration(
    val aspectRatio: Float? = null,
    val backgroundColor: Color? = null,
    val shape: Shape = RectangleShape,
    val contentScale: ContentScale = ContentScale.Fit,
    val contentPadding: PaddingValues = PaddingValues(),
)
