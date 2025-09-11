package com.bonface.designsystem.components.buttons.style

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import com.bonface.designsystem.R
import com.bonface.designsystem.extensions.dimensions

object ButtonStyleDefaults {

    val Default: ButtonStyle
        @Composable @ReadOnlyComposable
        get() = ButtonStyle(
            textStyle = MaterialTheme.typography.bodyMedium,
            size = DpSize(
                width = dimensionResource(R.dimen.button_min_width),
                height = dimensionResource(R.dimen.button_default_height),
            ),
        )

    val Small: ButtonStyle
        @Composable @ReadOnlyComposable
        get() = ButtonStyle(
            padding = PaddingValues(
                horizontal = MaterialTheme.dimensions.small,
                vertical = MaterialTheme.dimensions.xxSmall,
            ),
            textStyle = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Normal),
            size = DpSize(
                width = dimensionResource(R.dimen.button_min_width),
                height = dimensionResource(R.dimen.button_small_height),
            ),
        )
}
