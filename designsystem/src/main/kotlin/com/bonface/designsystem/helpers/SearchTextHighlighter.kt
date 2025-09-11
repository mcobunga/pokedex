package com.bonface.designsystem.helpers

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle

/**
 * Highlights all occurrences of a given [query] within the provided [text].
 *
 * - The input [text] is first converted to title case for consistent display.
 * - If [query] is blank, the original text (title-cased) is returned unmodified.
 * - Matching substrings are styled using the provided [highlightColor].
 * - Matching is case-insensitive.
 *
 * Example:
 * ```
 * highlightIfMatches("pikachu electric type", "chu", Color.Yellow)
 * ```
 * will return an [AnnotatedString] where "Chu" in "Pikachu" is highlighted in yellow.
 *
 * @param text The input string to be processed and highlighted.
 * @param query The substring to match and highlight. Case-insensitive.
 * @param highlightColor The [Color] applied to the matched portions of the text.
 *
 * @return An [AnnotatedString] containing the text with highlighted matches.
 */
fun highlightIfMatches(text: String, query: String, highlightColor: Color): AnnotatedString {
    // Have the name in title case
    val titleCaseText = text.toTitleCase()
    if (query.isBlank()) return AnnotatedString(titleCaseText)

    val builder = AnnotatedString.Builder()
    val lowerText = titleCaseText.lowercase()
    val lowerQuery = query.lowercase()

    var currentIndex = 0
    while (currentIndex < titleCaseText.length) {
        val matchIndex = lowerText.indexOf(lowerQuery, currentIndex)
        if (matchIndex == -1) {
            builder.append(titleCaseText.substring(currentIndex))
            break
        }

        // Append the unmatched part
        if (matchIndex > currentIndex) {
            builder.append(titleCaseText.substring(currentIndex, matchIndex))
        }

        // Append the matched part with style
        builder.withStyle(style = SpanStyle(color = highlightColor)) {
            append(titleCaseText.substring(matchIndex, matchIndex + query.length))
        }

        currentIndex = matchIndex + query.length
    }

    return builder.toAnnotatedString()
}

/**
 * Converts the string into title case, ensuring each word starts with an uppercase
 * character and the rest are lowercase.
 *
 * Example:
 * ```
 * "pikachu electric TYPE".toTitleCase() // "Pikachu Electric Type"
 * ```
 *
 * @receiver The input string.
 * @return The transformed string in title case.
 */
private fun String.toTitleCase(): String {
    return lowercase()
        .split(SPACE).joinToString(separator = SPACE) { it.replaceFirstChar { s -> s.uppercaseChar() } }
}
