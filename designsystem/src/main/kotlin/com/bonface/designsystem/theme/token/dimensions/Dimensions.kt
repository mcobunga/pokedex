package com.bonface.designsystem.theme.token.dimensions

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines a standardized set of spacing, sizing, and layout dimension values
 * used across the UI. Each property represents a predefined [Dp] unit that
 * promotes consistency and scalability in component design.
 *
 * These values should be preferred over hardcoded `Dp` values to ensure
 * maintainability and alignment with the design system.
 *
 * @property none Represents no spacing or size (0.dp).
 * @property xxxSmall Extremely small dimension, used for tight spacing.
 * @property xxSmall Very small dimension for subtle spacing adjustments.
 * @property xSmall Small dimension for compact spacing.
 * @property small Standard small spacing.
 * @property medium Balanced spacing used for most components.
 * @property large Large spacing for prominent separation.
 * @property xLarge Extra-large spacing for wide layouts or padding.
 * @property xxLarge Maximum spacing value for highly spacious layouts.
 */
class Dimensions(
    val none: Dp = 0.dp,
    val xxxSmall: Dp = 0.dp,
    val xxSmall: Dp = 0.dp,
    val xSmall: Dp = 0.dp,
    val small: Dp = 0.dp,
    val medium: Dp = 0.dp,
    val large: Dp = 0.dp,
    val xLarge: Dp = 0.dp,
    val xxLarge: Dp = 0.dp,
)

/**
 * CompositionLocal that provides access to the current [Dimensions] set.
 *
 * Use this within composables to retrieve theme-specific dimension values
 * instead of hardcoding `Dp`, enabling adaptive layouts and theme consistency.
 */
internal val LocalDimensions = staticCompositionLocalOf { Dimensions() }

