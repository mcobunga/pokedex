package com.bonface.designsystem.extensions

import androidx.annotation.ColorInt
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.graphics.ColorUtils
import kotlin.math.absoluteValue

/**
 * Generates a deterministic HSL-based color from this [String].
 *
 * The function hashes the characters of the string into a hue value
 * (ranging from `0..359`) and applies the provided [saturation] and [lightness]
 * values to produce a stable color output. This ensures that the same string
 * will always map to the same color.
 *
 * This is useful for generating unique yet consistent colors for items such
 * as usernames, Pokémon types, tags, or categories without having to hardcode
 * a palette.
 *
 * @param saturation the saturation of the resulting color in the range `0f..1f`.
 * Defaults to `0.5f` for balanced vibrancy.
 * @param lightness the base lightness of the resulting color in the range `0f..1f`.
 * Defaults to `0.85f` for lighter colors.
 * @param adjustLightness whether to use the provided [lightness] (`true`)
 * or a darker fallback value (`0.3f`) for stronger contrast (`false`).
 * Defaults to `true`.
 *
 * @return an ARGB color [Int] representation of the generated HSL color.
 *
 * Example:
 * ```
 * val color1 = "Bulbasaur".toHslColor()
 * val color2 = "Charmander".toHslColor(saturation = 0.7f, lightness = 0.6f)
 * ```
 */
@ColorInt
fun String.toHslColor(
    saturation: Float = 0.5f,
    lightness: Float = 0.85f,
    adjustLightness: Boolean = true
): Int {
    val adjustedLightness = if (adjustLightness) lightness else 0.3f
    val hue = fold(0) { acc, char -> char.code + acc * 37 } % 360
    return ColorUtils.HSLToColor(
        floatArrayOf(hue.absoluteValue.toFloat(), saturation, adjustedLightness)
    )
}

@Composable
fun textFieldOutlineColor(hasError: Boolean, isFocused: Boolean): Color {
    val nonErrorColor = if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
    return if (hasError) MaterialTheme.colorScheme.error else nonErrorColor
}

