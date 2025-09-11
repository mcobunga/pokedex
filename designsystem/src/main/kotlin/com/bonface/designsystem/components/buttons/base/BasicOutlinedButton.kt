package com.bonface.designsystem.components.buttons.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Basic outlined button
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
fun BasicOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonColorDefaults.outlined(),
    style: ButtonStyle = ButtonStyleDefaults.Default,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(
            minWidth = style.size.width,
            minHeight = style.size.height,
        ),
        border = BorderStroke(
            width = MaterialTheme.dimensions.xxxSmall,
            color = if (enabled) colors.outlineColor else colors.disabledOutlineColor,
        ),
        shape = MaterialTheme.shapes.medium,
        contentPadding = style.padding,
        enabled = enabled,
        content = content,
    )
}

/** Basic outline button preview */
@Composable
@PreviewLightDark
private fun BasicOutlinedButtonPreview() {
    PokedexTheme {
        Surface {
            BasicOutlinedButton(
                onClick = {},
                colors = ButtonColorDefaults.outlined(
                    outlineColor = MaterialTheme.colorScheme.primary,
                    disabledOutlineColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
                ),
                modifier = Modifier.padding(16.dp),
            ) {
                Text("Basic Button")
            }
        }
    }
}
