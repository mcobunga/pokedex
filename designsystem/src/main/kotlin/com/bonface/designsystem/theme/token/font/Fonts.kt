package com.bonface.designsystem.theme.token.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.bonface.designsystem.R

/**
 * A [FontFamily] definition for the **Lexend** typeface used throughout the app.
 *
 * This family includes multiple font weights to support different text styles:
 * - [FontWeight.Normal] → `lexend_regular`
 * - [FontWeight.Light] → `lexend_light`
 * - [FontWeight.Medium] → `lexend_medium`
 * - [FontWeight.SemiBold] → `lexend_semibold`
 * - [FontWeight.Bold] → `lexend_bold`
 *
 * Use this font family when defining typography in [MaterialTheme.typography] to ensure
 * consistent text rendering across the app.
 *
 * Example:
 * ```
 * val Typography = Typography(
 *     bodyLarge = TextStyle(
 *         fontFamily = LexendFontFamily,
 *         fontWeight = FontWeight.Normal,
 *         fontSize = 16.sp
 *     )
 * )
 * ```
 */
val LexendFontFamily = FontFamily(
    Font(resId = R.font.lexend_regular),
    Font(resId = R.font.lexend_light, weight = FontWeight.Light),
    Font(resId = R.font.lexend_medium, weight = FontWeight.Medium),
    Font(resId = R.font.lexend_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.lexend_bold, weight = FontWeight.Bold),
)
