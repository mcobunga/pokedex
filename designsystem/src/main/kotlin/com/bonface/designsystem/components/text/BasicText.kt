package com.bonface.designsystem.components.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.helpers.ONE
import com.bonface.designsystem.theme.PokedexTheme

/**
 * A lightweight wrapper around [Text] that applies commonly used defaults
 * for typography, color, and layout within the app's theme.
 *
 * This component standardizes text rendering across the app while still
 * allowing for customization of style, alignment, wrapping, and decorations.
 * It is intended to be the base building block for displaying body-level
 * text in the Pokedex application.
 *
 * @param text the string to be displayed.
 * @param modifier the [Modifier] to be applied to this text, e.g. for
 * padding, click handling, or layout behavior. Defaults to [Modifier].
 * @param color the color of the text. Defaults to [MaterialTheme.colorScheme.onBackground].
 * @param fontStyle the style of the font (e.g., [FontStyle.Italic]). Defaults to [FontStyle.Normal].
 * @param fontWeight the weight of the font (e.g., [FontWeight.Bold]). Defaults to [FontWeight.Normal].
 * @param textDecoration decorations to paint on the text (e.g., underline). Defaults to `null`.
 * @param textAlign the alignment of the text within its bounds. Defaults to `null`.
 * @param overflow how visual overflow should be handled if the text does not fit
 * within its bounds. Defaults to [TextOverflow.Ellipsis].
 * @param softWrap whether the text should break at soft line breaks. Defaults to `true`.
 * @param maxLines the maximum number of lines to display. Defaults to [Int.MAX_VALUE].
 * @param minLines the minimum number of lines to display. Defaults to `1`.
 * @param style the typography style applied to the text. Defaults to
 * [MaterialTheme.typography.bodyMedium].
 *
 * Example usage:
 * ```
 * BasicText(
 *     text = "Bulbasaur",
 *     fontWeight = FontWeight.Bold,
 *     color = MaterialTheme.colorScheme.primary
 * )
 * ```
 */
@Composable
fun BasicText(
    text: String,
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

/** Basic text preview */
@Composable
@PreviewLightDark
private fun BasicTextPreview() {
    PokedexTheme {
        Surface {
            BasicText(
                text = "This is a simple text",
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
