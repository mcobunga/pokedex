package com.bonface.designsystem.theme.token.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Represents the extended color palette used across the application’s UI - Pokedex Theme.
 *
 * Unlike the default [androidx.compose.material3.ColorScheme], this class
 * defines custom semantic colors to support buttons, backgrounds, gradients,
 * shadows, shimmer effects, and context-specific tints. Centralizing these
 * values ensures design consistency and makes theme switching easier.
 *
 * All colors default to [Color.White] or [Color.Unspecified] and are expected
 * to be overridden by a design system or theme implementation.
 *
 * @property primaryButton Color applied to primary action buttons.
 * @property secondaryButton Color applied to secondary action buttons.
 * @property dangerButton Color applied to destructive or danger buttons.
 * @property tertiaryButton Color applied to tertiary action buttons.
 *
 * @property disabledPrimaryButton Background color of disabled primary buttons.
 * @property onDisabledPrimaryButton Foreground color (text/icon) on disabled primary buttons.
 * @property disabledSecondaryButton Background color of disabled secondary buttons.
 * @property onDisabledSecondaryButton Foreground color on disabled secondary buttons.
 *
 * @property disabled General background color for disabled states.
 * @property onDisabled Foreground color (text/icon) on disabled components.
 *
 * @property white Neutral white color reference for consistency.
 *
 * @property icon Default tint color for icons.
 * @property iconShadow Shadow color applied to icons.
 * @property cardShadow Shadow color applied to cards.
 *
 * @property homeBackground Background color for the home screen.
 * @property componentBackground Background color for components and surfaces.
 * @property unselectedChipsBackground Background color for unselected chip components.
 *
 * @property shimmerStart Start color of shimmer animation.
 * @property shimmerCenter Middle color of shimmer animation.
 * @property shimmerEnd End color of shimmer animation.
 *
 * @property gradientStart Start color of a standard gradient.
 * @property gradientEnd End color of a standard gradient.
 * @property gradientErrorStart Start color of an error gradient.
 * @property gradientErrorEnd End color of an error gradient.
 *
 * @property tertiaryBlueDim A muted blue context color.
 * @property tertiaryBlueBright A bright blue context color.
 * @property tertiaryPearl A pearl-like neutral context color.
 * @property tertiarySky A sky-like context color.
 * @property tertiaryOrange A vibrant orange context color.
 * @property tertiaryLime A fresh lime context color.
 *
 * @property statusBar Background color applied to the status bar.
 */
@Immutable
class ColorScheme(
    val primaryButton: Color = Color.White,
    val secondaryButton: Color = Color.White,
    val dangerButton: Color = Color.White,
    val tertiaryButton: Color = Color.White,

    val disabledPrimaryButton: Color = Color.White,
    val onDisabledPrimaryButton: Color = Color.White,
    val disabledSecondaryButton: Color = Color.White,
    val onDisabledSecondaryButton: Color = Color.White,

    val disabled: Color = Color.White,
    val onDisabled: Color = Color.White,

    val white: Color = Color.White,

    val icon: Color = Color.Unspecified,
    val iconShadow: Color = Color.Unspecified,
    val cardShadow: Color = Color.Unspecified,

    val homeBackground: Color = Color.White,
    val componentBackground: Color = Color.White,
    val unselectedChipsBackground: Color = Color.White,

    val shimmerStart: Color = Color.White,
    val shimmerCenter: Color = Color.White,
    val shimmerEnd: Color = Color.White,

    val gradientStart: Color = Color.White,
    val gradientEnd: Color = Color.White,
    val gradientErrorStart: Color = Color.White,
    val gradientErrorEnd: Color = Color.White,

    // Context colors
    val tertiaryBlueDim: Color = Color.White,
    val tertiaryBlueBright: Color = Color.White,
    val tertiaryPearl: Color = Color.White,
    val tertiarySky: Color = Color.White,
    val tertiaryOrange: Color = Color.White,
    val tertiaryLime: Color = Color.White,

    val statusBar: Color = Color.White,
)

/**
 * CompositionLocal that provides the current [ColorScheme].
 *
 * This allows composables to access custom semantic colors without explicitly
 * passing them down the composition tree, ensuring theme consistency across the UI.
 */
internal val LocalColorScheme = staticCompositionLocalOf { ColorScheme() }

