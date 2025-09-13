package com.bonface.designsystem.components.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import com.bonface.designsystem.R
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.components.image.BasicImage
import com.bonface.designsystem.components.image.ImageConfigurationDefaults

/**
 * A custom [SnackbarHost] implementation that renders snackbars inside
 * a styled [Surface] with consistent theming and branding.
 *
 * This container wraps the default snackbar visuals to provide:
 * - Rounded corners
 * - Themed background and text colors
 * - Custom elevation and padding
 * - Inline icon support
 *
 * Useful when you need application-wide snackbar styling that aligns
 * with the design system while still leveraging [SnackbarHostState]
 * for state management.
 *
 * @param modifier the [Modifier] applied to the container surface,
 * controlling size, layout, and additional decorations. Defaults to [Modifier].
 * @param snackbarHostState the state object to manage and display snackbars.
 * Typically remembered at a higher level (e.g., `Scaffold`).
 * @param color the background color of the snackbar container surface.
 * Defaults to [MaterialTheme.customColors.componentBackground].
 *
 * @see SnackbarHost
 * @see SnackbarHostState
 */
@Composable
fun SnackbarContainer(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    color: Color = MaterialTheme.customColors.tertiaryOrange,
) {
    SnackbarHost(snackbarHostState) { snackbarData ->
        Surface(
            // Wrapping the Snackbar inside a Surface for full customization
            modifier = modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimensions.medium)
                .clip(RoundedCornerShape(dimensionResource(R.dimen.snackbar_rounded_corner_radius))),
            color = color,
            contentColor = MaterialTheme.customColors.white,
            shadowElevation = MaterialTheme.dimensions.xSmall,
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.dimensions.medium,
                        vertical = dimensionResource(R.dimen.snackbar_vertical_padding),
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.small),
            ) {
                BasicImage(
                    imagePainter = painterResource(R.drawable.ic_info_circle),
                    imageConfiguration = ImageConfigurationDefaults.circular(),
                    modifier = Modifier.size(MaterialTheme.dimensions.medium)
                        .background(MaterialTheme.customColors.white, shape = RoundedCornerShape(MaterialTheme.dimensions.large)),
                )
                BasicText(
                    text = snackbarData.visuals.message,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.customColors.white,
                )
            }
        }
    }
}
