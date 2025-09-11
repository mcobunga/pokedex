package com.bonface.pokedex.ui.detailscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.bonface.designsystem.components.progress.LineProgressIndicator
import com.bonface.designsystem.components.progress.LineProgressIndicatorState
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.capitalizeFirst
import com.bonface.designsystem.extensions.dimensions
import com.bonface.pokedex.R

@Composable
fun PokemonStats(
    name: String?,
    stats: List<Pair<String, Int>>?,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.small),
        modifier = modifier
    ) {
        BasicText(
            text = stringResource(id = R.string.pokemon_stats, name.orEmpty().capitalizeFirst()),
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        )

        stats?.forEach { (label, progress) ->
            StatRow(
                label = label.capitalizeFirst(),
                progress = progress,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun StatRow(
    label: String,
    progress: Int,
    modifier: Modifier = Modifier
) {
    val progressState = remember { LineProgressIndicatorState() }

    Row(
        modifier = modifier.padding(vertical = MaterialTheme.dimensions.xSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BasicText(
            text = stringResource(R.string.stat_value, label, progress.toString()),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )

        Box(modifier = Modifier.weight(1f)) {
            LineProgressIndicator(
                progressState = progressState,
                modifier = Modifier.padding(
                    vertical = MaterialTheme.dimensions.medium,
                    horizontal = MaterialTheme.dimensions.xSmall,
                ),
            )
            LaunchedEffect(key1 = Unit) {
                progressState.updateProgress(progress.toFloat())
            }
        }
    }
}
