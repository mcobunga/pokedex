package com.bonface.designsystem.components.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Button text
 *
 * @param text
 * @param textColor
 * @param textStyle
 * @param modifier
 */
@Composable
fun ButtonText(
    text: String,
    textColor: Color,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    BasicText(
        modifier = modifier,
        text = text,
        color = textColor,
        style = textStyle,
    )
}

/** Button text preview */
@Composable
@PreviewLightDark
private fun ButtonTextPreview() {
    PokedexTheme {
        Surface {
            ButtonText(
                text = "Button Text",
                textColor = MaterialTheme.colorScheme.onBackground,
                textStyle = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
