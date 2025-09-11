@file:Suppress("UnusedReceiverParameter")

package com.bonface.designsystem.extensions

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.bonface.designsystem.theme.token.avatar.Avatars
import com.bonface.designsystem.theme.token.avatar.LocalAvatars
import com.bonface.designsystem.theme.token.colors.ColorScheme
import com.bonface.designsystem.theme.token.colors.LocalColorScheme
import com.bonface.designsystem.theme.token.dimensions.Dimensions
import com.bonface.designsystem.theme.token.dimensions.LocalDimensions
import com.bonface.designsystem.theme.token.elevations.Elevations
import com.bonface.designsystem.theme.token.elevations.LocalElevations

/**
 * Theme extension properties for accessing custom design system values
 * through [MaterialTheme].
 *
 * These extensions provide a clean and consistent way to retrieve
 * app-specific theme definitions (colors, dimensions, elevations, avatars)
 * from the current [CompositionLocal]s, alongside the standard Material 3
 * theme tokens.
 *
 * Usage example:
 * ```
 * Box(
 *     modifier = Modifier
 *         .size(MaterialTheme.dimensions.large)
 *         .background(MaterialTheme.customColors.homeBackground)
 *         .shadow(MaterialTheme.elevations.small)
 * )
 *
 * Image(
 *     painter = painterResource(R.drawable.avatar),
 *     contentDescription = null,
 *     modifier = Modifier.size(MaterialTheme.avatars.medium)
 * )
 * ```
 */
val MaterialTheme.customColors: ColorScheme
    @Composable @ReadOnlyComposable
    get() = LocalColorScheme.current

val MaterialTheme.dimensions: Dimensions
    @Composable @ReadOnlyComposable
    get() = LocalDimensions.current

val MaterialTheme.elevations: Elevations
    @Composable @ReadOnlyComposable
    get() = LocalElevations.current

val MaterialTheme.avatars: Avatars
    @Composable @ReadOnlyComposable
    get() = LocalAvatars.current
