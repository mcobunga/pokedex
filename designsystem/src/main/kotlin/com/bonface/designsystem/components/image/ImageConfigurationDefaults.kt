package com.bonface.designsystem.components.image

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import com.bonface.designsystem.components.image.ImageConfiguration

object ImageConfigurationDefaults {

    /**
     * Creates an [ImageConfiguration] for square images with a 1:1 aspect
     * ratio.
     *
     * @param backgroundColor The background color to be applied behind the image.
     * @param contentScale The content scale to be used for the image.
     * @param contentPadding The padding to be applied within the image.
     */
    @Composable
    @ReadOnlyComposable
    fun square(
        backgroundColor: Color? = null,
        contentScale: ContentScale = ContentScale.Crop,
        contentPadding: PaddingValues = PaddingValues(),
    ): ImageConfiguration = ImageConfiguration(
        aspectRatio = 1f,
        contentScale = contentScale,
        contentPadding = contentPadding,
        backgroundColor = backgroundColor,
    )

    /**
     * Creates an [ImageConfiguration] for circular images.
     *
     * @param backgroundColor The background color to be applied behind the image.
     * @param contentScale The content scale to be used for the image.
     * @param contentPadding The padding to be applied within the image.
     */
    @Composable
    @ReadOnlyComposable
    fun circular(
        backgroundColor: Color? = null,
        contentScale: ContentScale = ContentScale.Crop,
        contentPadding: PaddingValues = PaddingValues(),
    ): ImageConfiguration = ImageConfiguration(
        aspectRatio = 1f,
        shape = CircleShape,
        contentScale = contentScale,
        contentPadding = contentPadding,
        backgroundColor = backgroundColor,
    )

    /**
     * Creates an [ImageConfiguration] for rounded images.
     *
     * @param backgroundColor The background color to be applied behind the image.
     * @param shape The shape to be used for the image corners.
     * @param contentScale The content scale to be used for the image.
     * @param contentPadding The padding to be applied within the image.
     */
    @Composable
    @ReadOnlyComposable
    fun rounded(
        backgroundColor: Color? = null,
        shape: Shape = MaterialTheme.shapes.large,
        contentScale: ContentScale = ContentScale.Crop,
        contentPadding: PaddingValues = PaddingValues(),
    ): ImageConfiguration = ImageConfiguration(
        shape = shape,
        contentScale = contentScale,
        contentPadding = contentPadding,
        backgroundColor = backgroundColor,
    )
}
