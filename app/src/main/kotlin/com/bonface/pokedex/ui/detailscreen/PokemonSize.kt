package com.bonface.pokedex.ui.detailscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.bonface.designsystem.components.spacers.VerticalSpace
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.pokedex.R

@Composable
fun PokemonSize(
    weight: String?,
    height: String?,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = MaterialTheme.dimensions.small),
    ) {
        BasicText(
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.weight(1f),
            text = stringResource(id = R.string.pokemon_weight, weight ?: stringResource(R.string.unknown)
            ),
            fontWeight = FontWeight.Bold
        )
        BasicText(
            text = stringResource(id = R.string.pokemon_height, height ?: stringResource(R.string.unknown)),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.weight(1f),
            fontWeight = FontWeight.Bold
        )
    }

    VerticalSpace(MaterialTheme.dimensions.medium)
}