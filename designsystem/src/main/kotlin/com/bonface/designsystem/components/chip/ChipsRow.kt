package com.bonface.designsystem.components.chip

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Chips row
 *
 * @param chips
 * @param selectedChip
 * @param onChipSelected
 * @param modifier
 * @receiver
 * @sample com.bonface.designsystem.components.chip.ChipsRowPreview
 */
@Composable
fun ChipsRow(
    chips: List<String>,
    selectedChip: String,
    onChipSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    cornerShape: ChipCornerShape = ChipCornerShapeDefaults.default,
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.dimensions.medium)
            .horizontalScroll(rememberScrollState()),
    ) {
        chips.forEach { option ->
            BasicFilterChip(
                text = option,
                selected = selectedChip == option,
                onClick = { onChipSelected(option) },
                modifier = Modifier.padding(end = MaterialTheme.dimensions.medium),
                cornerShape = cornerShape,
            )
        }
    }
}

/** Chips row preview */
@Composable
@PreviewLightDark
private fun ChipsRowPreview() {
    PokedexTheme {
        Surface {
            ChipsRow(
                chips = listOf("All", "Daily", "Weekly", "Monthly"),
                selectedChip = "All",
                onChipSelected = {},
            )
        }
    }
}
