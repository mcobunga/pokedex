package com.bonface.pokedex.ui.detailscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.bonface.designsystem.components.chip.ChipsRow
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.pokedex.R

@Composable
internal fun PokemonAbilities(
    name: String?,
    abilities: List<Pair<String, Boolean>>?,
) {
    Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium)) {
        BasicText(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(id = R.string.pokemon_abilities, name.toString().replaceFirstChar { it.titlecase() }),
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold
        )
        val chips: List<String> = abilities?.map { it.first } ?: emptyList()
        val selectedChip: String = abilities
            ?.firstOrNull { it.second }
            ?.first
            .orEmpty()

        ChipsRow(
            chips = chips,
            selectedChip = selectedChip,
        )
    }
}