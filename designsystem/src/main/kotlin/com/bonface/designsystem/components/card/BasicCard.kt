package com.bonface.designsystem.components.card

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.elevations
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Basic card
 *
 * @param modifier
 * @param style
 * @param clickable
 * @param onClick
 * @param content
 * @receiver
 * @receiver
 * @sample com.bonface.designsystem.components.card.BasicCardStandardPreview
 * @sample com.bonface.designsystem.components.card.BasicCardStrokedPreview
 */
@Composable
fun BasicCard(
    modifier: Modifier = Modifier,
    style: CardStyle = CardStyleDefaults.default(),
    clickable: Boolean = false,
    onClick: () -> Unit = { },
    content: @Composable () -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = MaterialTheme.elevations.none),
        enabled = clickable,
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = style.color,
            disabledContentColor = style.color,
            disabledContainerColor = style.color,
        ),
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = style.elevation,
                shape = style.shadowShape,
                clip = true,
                ambientColor = MaterialTheme.customColors.cardShadow,
                spotColor = MaterialTheme.customColors.cardShadow,
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing,
                ),
            ),
        shape = style.shape,
    ) { content() }
}

/** Basic card standard preview */
@Composable
@PreviewLightDark
private fun BasicCardStandardPreview() {
    PokedexTheme {
        Surface {
            BasicCard(modifier = Modifier.padding(16.dp)) {
                LazyColumn(Modifier.padding(16.dp)) {
                    items(3) {
                        Text(text = "Card Text", color = MaterialTheme.colorScheme.onBackground)
                    }
                }
            }
        }
    }
}

/** Basic card stroked preview */
@Composable
@PreviewLightDark
private fun BasicCardStrokedPreview() {
    PokedexTheme {
        Surface {
            BasicCard(
                style = CardStyleDefaults.stroked(),
                modifier = Modifier.padding(16.dp),
            ) {
                LazyColumn(Modifier.padding(16.dp)) {
                    items(3) {
                        Text(text = "Card Text", color = MaterialTheme.colorScheme.onBackground)
                    }
                }
            }
        }
    }
}
