package com.bonface.designsystem.theme.token.elevations

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines a semantic set of elevation values used across the application’s UI.
 *
 * Elevation controls the visual depth of components by applying shadows, which helps
 * distinguish surfaces and convey hierarchy in Material Design.
 *
 * @property none   Zero elevation, typically used for flat surfaces.
 * @property xSmall Extra small elevation, used for subtle surface separation.
 * @property small  Small elevation, often applied to lightweight components.
 * @property medium Medium elevation, commonly used for cards or floating elements.
 * @property large  Large elevation, used for emphasized surfaces.
 * @property xLarge Extra large elevation, applied to highly prominent elements.
 * @property max    Maximum elevation, reserved for top-level surfaces such as dialogs.
 */
class Elevations(
    val none: Dp = 0.dp,
    val xSmall: Dp = 0.dp,
    val small: Dp = 0.dp,
    val medium: Dp = 0.dp,
    val large: Dp = 0.dp,
    val xLarge: Dp = 0.dp,
    val max: Dp = 0.dp,
)

/**
 * CompositionLocal for providing [Elevations] to the UI hierarchy.
 *
 * Use [LocalElevations] to access the current set of elevation values within a composable.
 * This enables consistent elevation semantics across components and themes.
 */
internal val LocalElevations = staticCompositionLocalOf { Elevations() }

