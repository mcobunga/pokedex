package com.bonface.designsystem.components.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.buttons.base.BasicOutlinedButton
import com.bonface.designsystem.components.buttons.style.ButtonColorDefaults
import com.bonface.designsystem.components.buttons.style.ButtonStyle
import com.bonface.designsystem.components.buttons.style.ButtonStyleDefaults
import com.bonface.designsystem.components.spacers.VerticalSpace
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Secondary button
 *
 * @param text
 * @param onClick
 * @param modifier
 * @param style
 * @param enabled
 * @receiver
 * @sample com.bonface.designsystem.components.buttons.SecondaryButtonPreview
 */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: ButtonStyle = ButtonStyleDefaults.Default,
    enabled: Boolean = true,
) {
    val textColor = when {
        enabled -> MaterialTheme.customColors.secondaryButton
        else -> MaterialTheme.customColors.onDisabledSecondaryButton
    }

    BasicOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonColorDefaults.outlined(
            outlineColor = MaterialTheme.customColors.secondaryButton,
            disabledOutlineColor = MaterialTheme.customColors.disabledSecondaryButton,
        ),
        style = style,
    ) {
        ButtonText(
            text = text,
            textColor = textColor,
            textStyle = style.textStyle,
        )
    }
}

/** Secondary button default preview */
@Composable
@PreviewLightDark
private fun SecondaryButtonPreview() {
    PokedexTheme {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                SecondaryButton(
                    text = "Default",
                    onClick = {},
                )
                VerticalSpace(MaterialTheme.dimensions.small)
                SecondaryButton(
                    text = "Default Disabled",
                    enabled = false,
                    onClick = {},
                )
                VerticalSpace(MaterialTheme.dimensions.small)
                SecondaryButton(
                    text = "Small",
                    style = ButtonStyleDefaults.Small,
                    onClick = {},
                )
                VerticalSpace(MaterialTheme.dimensions.small)
                SecondaryButton(
                    text = "Small Disabled",
                    style = ButtonStyleDefaults.Small,
                    enabled = false,
                    onClick = {},
                )
            }
        }
    }
}
