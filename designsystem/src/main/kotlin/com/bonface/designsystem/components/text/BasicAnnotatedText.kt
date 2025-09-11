package com.bonface.designsystem.components.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.extensions.formatBold
import com.bonface.designsystem.helpers.ONE
import com.bonface.designsystem.theme.PokedexTheme

/**
 * A lightweight wrapper around [Text] for rendering [AnnotatedString]s
 * with consistent theming across the application.
 *
 * This component standardizes text rendering while supporting inline
 * text annotations such as bold, color spans, and clickable regions.
 * It is intended for flexible text composition with rich formatting.
 *
 * @param text the [AnnotatedString] content to display, allowing
 * rich text formatting such as spans or inline styles.
 * @param modifier the [Modifier] to be applied to this text,
 * enabling layout, padding, click handling, and other decorations.
 * Defaults to [Modifier].
 * @param color the color of the text. Defaults to
 * [MaterialTheme.colorScheme.onBackground].
 * @param fontStyle the style of the font (e.g., [FontStyle.Italic]).
 * Defaults to [FontStyle.Normal].
 * @param fontWeight the weight of the font (e.g., [FontWeight.Bold]).
 * Defaults to [FontWeight.Normal].
 * @param textDecoration optional decorations to paint on the text
 * (e.g., underline, strikethrough). Defaults to `null`.
 * @param textAlign the alignment of the text within its bounds.
 * Defaults to `null`.
 * @param overflow how visual overflow should be handled if the text
 * exceeds its bounds. Defaults to [TextOverflow.Ellipsis].
 * @param softWrap whether the text should break at soft line breaks.
 * If false, text will be clipped. Defaults to `true`.
 * @param maxLines the maximum number of lines to display. Use
 * [Int.MAX_VALUE] for unlimited. Defaults to [Int.MAX_VALUE].
 * @param minLines the minimum number of lines to display. Defaults to `1`.
 * @param style the typography style applied to the text. Defaults to
 * [MaterialTheme.typography.bodyMedium].
 *
 * @sample com.bonface.designsystem.components.text.BasicTextPreview
 */
@Composable
fun BasicText(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onBackground,
    fontStyle: FontStyle? = FontStyle.Normal,
    fontWeight: FontWeight? = FontWeight.Normal,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = ONE,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        minLines = minLines,
        style = style,
    )
}

/** Basic  text preview */
@Composable
@PreviewLightDark
private fun BasicTextPreview() {
    // Example
    val message = "This is an annotated text."
    val textsToFormat = listOf("annotated")
    val annotatedString = message.formatBold(textsToFormat)

    PokedexTheme {
        Surface {
            BasicText(
                text = annotatedString,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
