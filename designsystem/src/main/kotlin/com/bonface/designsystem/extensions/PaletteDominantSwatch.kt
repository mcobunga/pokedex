package com.bonface.designsystem.extensions

import android.graphics.Bitmap
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette

/**
 * Produces a background [Color] derived from the dominant color of a given [Bitmap].
 *
 * This composable uses [Palette] to extract the dominant swatch from the image and then
 * adjusts its brightness for better readability and contrast. If no bitmap is provided
 * or if a dominant swatch cannot be determined, it falls back to the theme's default
 * background color.
 *
 * Internally, it leverages [remember] and [derivedStateOf] to ensure recompositions
 * only occur when the provided bitmap changes.
 *
 * @param bitmap the optional [Bitmap] from which the dominant color should be extracted.
 *        If `null`, the default background color from [MaterialTheme] is returned.
 *
 * @return a [State] holding the computed background [Color] that updates automatically
 *         when the [bitmap] changes.
 *
 * @see adjustColorBrightness for brightness adjustment logic applied to extracted colors.
 * @see androidx.palette.graphics.Palette for color extraction details.
 */
@Composable
fun derivedBackgroundColor(bitmap: Bitmap?): State<Color> {
    val defaultColor = MaterialTheme.colorScheme.background

    return remember(bitmap) {
        derivedStateOf {
            bitmap?.let {
                val palette = Palette.from(it).generate()
                palette.dominantSwatch?.rgb
                    ?.let(::adjustColorBrightness)
                    ?.let(::Color)
            } ?: defaultColor
        }
    }
}

/**
 * Adjusts the brightness of a given color by blending it with white.
 *
 * The resulting color becomes lighter as the [factor] increases.
 *
 * @param color the original ARGB color to adjust.
 * @param factor the blending factor in the range `0f..1f`.
 *        - `0f` returns the original color.
 *        - `1f` returns pure white.
 *        Defaults to `0.7f`.
 *
 * @return a new ARGB color with adjusted brightness.
 */
private fun adjustColorBrightness(color: Int, factor: Float = 0.7f): Int {
    val r = (android.graphics.Color.red(color) * (1 - factor) + 255 * factor).toInt().coerceIn(0, 255)
    val g = (android.graphics.Color.green(color) * (1 - factor) + 255 * factor).toInt().coerceIn(0, 255)
    val b = (android.graphics.Color.blue(color) * (1 - factor) + 255 * factor).toInt().coerceIn(0, 255)
    return android.graphics.Color.rgb(r, g, b)
}
