package com.bonface.pokedex.ui.detailscreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.consumerapi.data.model.PokedexDetails
import com.bonface.designsystem.components.empty.EmptyContainer
import com.bonface.designsystem.components.loading.FullScreenLoadingIndicator
import com.bonface.designsystem.components.snackbar.SnackbarContainer
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme
import com.bonface.pokedex.R
import com.bonface.pokedex.viewmodel.PokemonDetailsUiState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PokemonDetailsScreen(
    uiState: PokemonDetailsUiState,
    snackbarHostState: SnackbarHostState,
    onRetry: () -> Unit = {},
    onBack: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarContainer(
                snackbarHostState = snackbarHostState,
                color = MaterialTheme.customColors.tertiaryBlueBright,
            )
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            when(uiState) {
                is PokemonDetailsUiState.Success -> {
                    PokemonDetailsContent(
                        pokedexDetails = uiState.details,
                        onBack = onBack,
                    )
                }

                is PokemonDetailsUiState.Error -> {
                    EmptyContainer(
                        title = uiState.error.asString(),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = MaterialTheme.dimensions.medium),
                        buttonText = stringResource(R.string.retry),
                        buttonOnClick = onRetry
                    )
                }

                is PokemonDetailsUiState.Loading -> FullScreenLoadingIndicator()
            }
        }
    }
}

@Composable
private fun PokemonDetailsContent(
    pokedexDetails: PokedexDetails,
    onBack: () -> Unit,
) {
    PokemonDetailsHeader(
        pokedexDetails,
        onBack = onBack
    )

    LazyColumn (
        modifier = Modifier
            .padding(MaterialTheme.dimensions.medium)
            .navigationBarsPadding(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium)
    ) {
        item { AboutPokemon(pokedexDetails.name, pokedexDetails.about) }

        item { PokemonAbilities(pokedexDetails.name, pokedexDetails.abilities) }

        item { PokemonSize(pokedexDetails.weight, pokedexDetails.height) }

        item { PokemonStats(pokedexDetails.name, pokedexDetails.stats) }
    }
}

@PreviewLightDark
@Composable
private fun PokemonDetailsScreenPreview() {
    val dummyPokedexDetails = PokedexDetails(
        pokemonId = "25",
        name = "Pikachu",
        about = "Pikachu that can generate powerful electricity have cheek sacs that are extra soft and super stretchy.",
        weight = "6.0 kg",
        height = "0.4 m",
        color = "Yellow",
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
        abilities = listOf(
            "Static" to true,
            "Lightning Rod" to false
        ),
        stats = listOf(
            "HP" to 35,
            "Attack" to 55,
            "Defense" to 40,
            "Special Attack" to 50,
            "Special Defense" to 50,
            "Speed" to 90
        ),
        types = listOf("Electric")
    )

    PokedexTheme {
        PokemonDetailsScreen(
            uiState = PokemonDetailsUiState.Success(dummyPokedexDetails),
            snackbarHostState = SnackbarHostState(),
            onBack = {}
        )
    }
}