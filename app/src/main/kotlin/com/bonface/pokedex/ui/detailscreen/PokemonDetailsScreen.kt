package com.bonface.pokedex.ui.detailscreen

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
fun PokemonDetailsScreen(
    onBack: () -> Unit
) {
    ScreenScaffoldContainer(
        screenTitle = "Pokemon Details",
        onBack = onBack
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium),
        ) {
            BasicText(text = "Hello Chameleon!")
        }
    }
}

@PreviewLightDark
@Composable
private fun PokemonDetailsScreenPreview() {
    PokedexTheme {
        PokemonDetailsScreen(onBack = {})
    }
}