package com.bonface.designsystem.components.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.buttons.base.BasicButton
import com.bonface.designsystem.components.buttons.style.ButtonColorDefaults
import com.bonface.designsystem.components.buttons.style.ButtonStyle
import com.bonface.designsystem.components.buttons.style.ButtonStyleDefaults
import com.bonface.designsystem.components.spacers.VerticalSpace
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Primary button
 *
 * @param text
 * @param onClick
 * @param modifier
 * @param style
 * @param enabled
 * @receiver
 * @sample com.bonface.designsystem.components.buttons.PrimaryButtonPreview
 */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: ButtonStyle = ButtonStyleDefaults.Default,
    enabled: Boolean = true,
) {
    val textColor = when {
        enabled -> MaterialTheme.colorScheme.onPrimary
        else -> MaterialTheme.customColors.onDisabledPrimaryButton
    }

    BasicButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonColorDefaults.filled(
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.customColors.disabledPrimaryButton,
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

/** Primary button preview */
@Composable
@PreviewLightDark
private fun PrimaryButtonPreview() {
    PokedexTheme {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                PrimaryButton(
                    text = "Default",
                    onClick = {},
                )
                VerticalSpace(MaterialTheme.dimensions.small)
                PrimaryButton(
                    text = "Default Disabled",
                    enabled = false,
                    onClick = {},
                )
                VerticalSpace(MaterialTheme.dimensions.small)
                PrimaryButton(
                    text = "Small",
                    style = ButtonStyleDefaults.Small,
                    onClick = {},
                )
                VerticalSpace(MaterialTheme.dimensions.small)
                PrimaryButton(
                    text = "Small Disabled",
                    style = ButtonStyleDefaults.Small,
                    enabled = false,
                    onClick = {},
                )
            }
        }
    }
}
