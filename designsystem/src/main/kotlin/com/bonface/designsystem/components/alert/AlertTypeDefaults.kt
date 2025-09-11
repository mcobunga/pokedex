package com.bonface.designsystem.components.alert

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.bonface.designsystem.extensions.customColors

object AlertTypeDefaults {
    private const val BACKGROUND_OPACITY = 0.08f
    private const val BORDER_OPACITY = 0.49f

    val InfoAlert
        @Composable @ReadOnlyComposable
        get() = AlertType(
            background = MaterialTheme.customColors.tertiaryBlueBright,
            borderColor = MaterialTheme.customColors.tertiaryBlueDim,
        )

    val WarningAlert
        @Composable @ReadOnlyComposable
        get() = AlertType(
            background = MaterialTheme.customColors.tertiaryOrange.copy(alpha = BACKGROUND_OPACITY),
            borderColor = MaterialTheme.customColors.tertiaryOrange.copy(alpha = BORDER_OPACITY),
        )

    val DangerAlert
        @Composable @ReadOnlyComposable
        get() = AlertType(
            background = MaterialTheme.colorScheme.error.copy(alpha = BACKGROUND_OPACITY),
            borderColor = MaterialTheme.colorScheme.error.copy(alpha = BORDER_OPACITY),
        )
}
