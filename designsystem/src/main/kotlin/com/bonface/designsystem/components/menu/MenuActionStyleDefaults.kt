package com.bonface.designsystem.components.menu

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/** Contains the default values for [MenuActionStyle]. */
object MenuActionStyleDefaults {

    /**
     * Creates a [MenuActionStyle] with default colors suitable for use on a
     * default toolbar.
     *
     * @param iconTint The tint to apply to the icon. Defaults to
     *    [Color.Unspecified], which means no tint will be applied.
     * @return A [MenuActionStyle] with the specified icon tint and the surface
     *    color as the container color.
     */
    @Composable
    fun defaultStyle(iconTint: Color = Color.Unspecified) = MenuActionStyle(
        iconTint = iconTint,
        containerColor = MaterialTheme.colorScheme.surface,
    )

    /**
     * Creates a [MenuActionStyle] with colors suitable for use on an toolbar
     * with an image background.
     *
     * @param iconTint The tint to apply to the icon.
     * @param contentColor The color to use for the container.
     * @return A [MenuActionStyle] with the specified icon tint and container color.
     */
    fun imageStyle(iconTint: Color, contentColor: Color) = MenuActionStyle(
        iconTint = iconTint,
        containerColor = contentColor,
    )
}
