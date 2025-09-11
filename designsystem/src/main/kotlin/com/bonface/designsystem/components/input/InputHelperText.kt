package com.bonface.designsystem.components.input

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.theme.PokedexTheme

/**
 * A lightweight text component intended to provide additional context or guidance
 * for an input field.
 *
 * Typically used to display validation messages, helper instructions, or inline
 * feedback below text fields. Styling follows the design system’s typography and
 * color guidelines.
 *
 * @param text the message to display as helper or error text.
 * @param modifier the [Modifier] to be applied to this text element.
 * @param textColor the color of the text. Defaults to [MaterialTheme.colorScheme.onSurface].
 *
 * @sample com.bonface.designsystem.components.input.InputHelperTextPreview
 * @sample com.bonface.designsystem.components.input.InputHelperTextErrorPreview
 *
 * @see InputTextField
 */
@Composable
fun InputHelperText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    BasicText(
        modifier = modifier,
        text = text,
        color = textColor,
        style = MaterialTheme.typography.bodySmall,
        fontWeight = FontWeight.Medium,
    )
}

/** Input helper text preview */
@Composable
@PreviewLightDark
private fun InputHelperTextPreview() {
    PokedexTheme {
        Surface {
            InputHelperText(
                text = "Helper text",
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}

/** Input helper text error preview */
@Composable
@PreviewLightDark
private fun InputHelperTextErrorPreview() {
    PokedexTheme {
        Surface {
            InputHelperText(
                text = "Helper text error",
                textColor = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
