package com.bonface.designsystem.components.alert

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.bonface.designsystem.components.alert.AlertBorder
import com.bonface.designsystem.extensions.dimensions

object AlertBorderDefaults {

    val None
        @Composable @ReadOnlyComposable
        get() = AlertBorder(cornerRadius = MaterialTheme.dimensions.small)

    val Line
        @Composable @ReadOnlyComposable
        get() = AlertBorder(
            width = MaterialTheme.dimensions.xxxSmall,
            cornerRadius = MaterialTheme.dimensions.small,
        )

    val Dashed
        @Composable @ReadOnlyComposable
        get() = AlertBorder(
            width = MaterialTheme.dimensions.xxxSmall,
            cornerRadius = MaterialTheme.dimensions.small,
            dashLength = MaterialTheme.dimensions.xSmall,
            gapLength = MaterialTheme.dimensions.xxSmall,
        )
}
