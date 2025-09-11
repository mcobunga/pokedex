package com.bonface.designsystem.components.buttons.style

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

object ButtonColorDefaults {

    /**
     * Filled
     *
     * @param containerColor
     * @param disabledContainerColor
     * @param textColor
     * @param disabledTextColor
     * @return
     */
    @Composable
    @ReadOnlyComposable
    fun filled(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        textColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledTextColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        disabledContainerColor = disabledContainerColor,
        textColor = textColor,
        disabledTextColor = disabledTextColor,
    )

    /**
     * Outlined
     *
     * @param outlineColor
     * @param disabledOutlineColor
     * @param textColor
     * @param disabledTextColor
     * @return
     */
    @Composable
    @ReadOnlyComposable
    fun outlined(
        outlineColor: Color = MaterialTheme.colorScheme.primary,
        disabledOutlineColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        textColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledTextColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        outlineColor = outlineColor,
        disabledOutlineColor = disabledOutlineColor,
        textColor = textColor,
        disabledTextColor = disabledTextColor,
    )
}
