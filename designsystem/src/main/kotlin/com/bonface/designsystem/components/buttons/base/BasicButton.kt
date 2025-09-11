package com.bonface.designsystem.components.buttons.base

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.buttons.style.ButtonColorDefaults
import com.bonface.designsystem.components.buttons.style.ButtonColors
import com.bonface.designsystem.components.buttons.style.ButtonStyle
import com.bonface.designsystem.components.buttons.style.ButtonStyleDefaults
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Basic button
 *
 * @param onClick
 * @param modifier
 * @param enabled
 * @param colors
 * @param style
 * @param content
 * @receiver
 * @receiver
 */
@Composable
fun BasicButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonColorDefaults.filled(),
    style: ButtonStyle = ButtonStyleDefaults.Default,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.containerColor,
            disabledContainerColor = colors.disabledContainerColor,
        ),
        shape = MaterialTheme.shapes.medium,
        contentPadding = style.padding,
        enabled = enabled,
        onClick = onClick,
        modifier = modifier.defaultMinSize(
            minWidth = style.size.width,
            minHeight = style.size.height,
        ),
        content = content,
    )
}

/** Basic button preview */
@Composable
@PreviewLightDark
private fun BasicButtonPreview() {
    PokedexTheme {
        Surface {
            BasicButton(
                onClick = {},
                colors = ButtonColorDefaults.filled(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                ),
                modifier = Modifier.padding(16.dp),
            ) {
                Text("Basic Button")
            }
        }
    }
}
