package com.bonface.designsystem.components.buttons.style

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize

/**
 * Button style
 *
 * @property padding
 * @property textStyle
 * @property size
 */
data class ButtonStyle(
    val padding: PaddingValues = ButtonDefaults.ContentPadding,
    val textStyle: TextStyle = TextStyle.Default,
    val size: DpSize = DpSize(Dp.Hairline, Dp.Hairline),
)
