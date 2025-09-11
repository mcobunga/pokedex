package com.bonface.designsystem.components.chip

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Basic filter chip
 *
 * @param text
 * @param onClick
 * @param modifier
 * @param selected
 * @param enabled
 * @param cornerShape
 * @receiver
 * @sample com.bonface.designsystem.components.chip.BasicFilterChipPreview
 */
@Composable
fun BasicFilterChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
    cornerShape: ChipCornerShape = ChipCornerShapeDefaults.default,
) {
    val labelColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
    val textColor = if (enabled) labelColor else MaterialTheme.customColors.onDisabledPrimaryButton

    FilterChip(
        modifier = modifier,
        onClick = onClick,
        label = {
            BasicText(
                text = text,
                modifier = Modifier.padding(horizontal = MaterialTheme.dimensions.xxSmall),
                color = textColor,
                style = MaterialTheme.typography.bodySmall,
            )
        },
        enabled = enabled,
        selected = selected,
        shape = cornerShape.shape,
        border = FilterChipDefaults.filterChipBorder(
            enabled = true,
            selected = true,
            borderColor = Color.Transparent,
        ),
        colors = FilterChipDefaults.filterChipColors(
            containerColor = MaterialTheme.customColors.unselectedChipsBackground,
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            disabledContainerColor = MaterialTheme.customColors.disabledPrimaryButton.copy(alpha = .25f),
            disabledSelectedContainerColor = MaterialTheme.customColors.disabledPrimaryButton.copy(alpha = .25f),
            disabledLabelColor = MaterialTheme.customColors.onDisabledPrimaryButton,
        ),
    )
}

/** Basic filter chip preview */
@Composable
@PreviewLightDark
private fun BasicFilterChipPreview() {
    PokedexTheme {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                BasicFilterChip(
                    text = "Default Filter Chip",
                    selected = true,
                    onClick = {},
                )
                BasicFilterChip(
                    text = "Default Filter Chip",
                    selected = false,
                    onClick = {},
                )
                BasicFilterChip(
                    text = "Rounded Filter Chip",
                    cornerShape = ChipCornerShapeDefaults.rounded,
                    selected = true,
                    onClick = {},
                )
                BasicFilterChip(
                    text = "Rounded Filter Chip",
                    cornerShape = ChipCornerShapeDefaults.rounded,
                    selected = false,
                    onClick = {},
                )
            }
        }
    }
}
