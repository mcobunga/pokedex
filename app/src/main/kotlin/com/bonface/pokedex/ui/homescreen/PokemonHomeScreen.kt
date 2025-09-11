package com.bonface.pokedex.ui.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.components.scaffold.ScreenScaffoldContainer
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme

@Composable
fun PokemonHomeScreen() {
    ScreenScaffoldContainer(
        screenTitle = "Pokemon Collection",
        leftActionProperties = null,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium),
        ) {
            BasicText(text = "Hello Pokemon!")
        }
    }
}

@PreviewLightDark
@Composable
private fun PokemonHomeScreenPreview() {
    PokedexTheme {
        PokemonHomeScreen()
    }
}