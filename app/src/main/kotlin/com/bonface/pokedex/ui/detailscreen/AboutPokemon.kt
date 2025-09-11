package com.bonface.pokedex.ui.detailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.bonface.designsystem.components.text.BasicText
import com.bonface.pokedex.R

@Composable
fun AboutPokemon(
    name: String?,
    description: String?
) {
    Column {
        BasicText(
            style = MaterialTheme.typography.titleMedium,
            text = stringResource(id = R.string.about_pokemon, name.toString().replaceFirstChar { it.titlecase() }),
            textDecoration = TextDecoration.Underline,
            fontWeight = FontWeight.Bold,
        )

        BasicText(
            style = MaterialTheme.typography.bodyMedium,
            text = description.toString(),
            fontWeight = FontWeight.Normal,
        )
    }
}