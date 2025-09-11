package com.bonface.designsystem.extensions

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight

/**
 * Applies **bold styling** to specific substrings within this [String],
 * returning the result as an [AnnotatedString].
 *
 * Each substring provided in [textsToFormat] will be searched for in the
 * original string. If found, it is styled with [FontWeight.SemiBold].
 * Substrings that do not exist in the source string are ignored.
 *
 * This is particularly useful for emphasizing certain words or phrases
 * in UI text without having to manually build an [AnnotatedString].
 *
 * Example:
 * ```
 * val text = "Pikachu is an Electric type Pokémon"
 * val bolded = text.formatBold(listOf("Pikachu", "Electric"))
 *
 * Text(bolded) // Renders "Pikachu" and "Electric" in semi-bold
 * ```
 *
 * @param textsToFormat list of substrings to apply semi-bold styling to.
 * @return [AnnotatedString] with the specified substrings styled in semi-bold.
 */
fun String.formatBold(textsToFormat: List<String>): AnnotatedString {
    val annotatedStringBuilder = AnnotatedString.Builder(this)
    for (text in textsToFormat) {
        val index = indexOf(text)
        if (index != -1) { // Check if text is found
            val size = text.length
            annotatedStringBuilder.addStyle(SpanStyle(fontWeight = FontWeight.SemiBold), index, size + index)
        }
    }
    return annotatedStringBuilder.toAnnotatedString()
}
