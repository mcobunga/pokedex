package com.bonface.designsystem.components.modifiers

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.components.card.BasicCard
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Conditional
 *
 * @param condition
 * @param modifier
 * @receiver
 * @return
 *
 * @sample com.bonface.designsystem.components.modifiers.ConditionalModifierPreview
 */
@Composable
fun Modifier.conditional(condition: Boolean, modifier: @Composable Modifier.() -> Modifier): Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}

@Composable
@PreviewLightDark
private fun ConditionalModifierPreview() {
    PokedexTheme {
        Surface {
            BasicCard(modifier = Modifier.conditional(true) { padding(16.dp) }) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Text",
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}
