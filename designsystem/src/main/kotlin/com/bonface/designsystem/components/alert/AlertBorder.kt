package com.bonface.designsystem.components.alert

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Alert border
 *
 * @constructor Create empty Alert border
 * @property width
 * @property cornerRadius
 * @property dashLength
 * @property gapLength
 */
data class AlertBorder(
    val width: Dp = 0.dp,
    val cornerRadius: Dp = 0.dp,
    val dashLength: Dp = 0.dp,
    val gapLength: Dp = 0.dp,
)
