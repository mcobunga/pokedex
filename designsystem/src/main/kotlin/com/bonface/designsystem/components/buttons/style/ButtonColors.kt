package com.bonface.designsystem.components.buttons.style

import androidx.compose.ui.graphics.Color

/**
 * Button colors
 *
 * @constructor Create empty Button colors
 * @property containerColor
 * @property disabledContainerColor
 * @property outlineColor
 * @property disabledOutlineColor
 * @property textColor
 * @property disabledTextColor
 */
data class ButtonColors(
    val containerColor: Color = Color.Unspecified,
    val disabledContainerColor: Color = Color.Unspecified,
    val outlineColor: Color = Color.Unspecified,
    val disabledOutlineColor: Color = Color.Unspecified,
    val textColor: Color = Color.Unspecified,
    val disabledTextColor: Color = Color.Unspecified,
)
