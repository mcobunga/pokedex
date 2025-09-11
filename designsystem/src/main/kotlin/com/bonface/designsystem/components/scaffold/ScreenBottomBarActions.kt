package com.bonface.designsystem.components.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.components.buttons.PrimaryButton
import com.bonface.designsystem.components.buttons.SecondaryButton
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Screen bottom bar actions
 *
 * @param actions
 * @param modifier
 * @sample com.bonface.designsystem.components.scaffold.ScreenActionBottomBarPreview
 */
@Composable
fun ScreenBottomBarActions(
    actions: List<@Composable RowScope.() -> Unit>,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium),
        modifier = modifier
            .fillMaxWidth()
            .padding(MaterialTheme.dimensions.medium),
    ) {
        actions.map { it() }
    }
}

/** Bottom sheet bottom bar preview */
@Composable
@PreviewLightDark
private fun ScreenActionBottomBarPreview() {
    PokedexTheme {
        Surface {
            ScreenBottomBarActions(
                actions = listOf(
                    { SecondaryButton(modifier = Modifier.weight(1F), text = "Cancel", onClick = {}) },
                    { PrimaryButton(modifier = Modifier.weight(1F), text = "Retry", onClick = {}) },
                ),
            )
        }
    }
}
