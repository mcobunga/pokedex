package com.bonface.pokedex.ui.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.consumerapi.data.model.Pokedex
import com.bonface.designsystem.components.empty.EmptyContainer
import com.bonface.designsystem.components.loading.FullScreenLoadingIndicator
import com.bonface.designsystem.components.scaffold.ScreenScaffoldContainer
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme
import com.bonface.pokedex.R
import com.bonface.pokedex.viewmodel.PokemonUiState
import kotlinx.collections.immutable.toImmutableList

@Composable
fun PokemonHomeScreen(
    uiState: PokemonUiState,
    navigateToPokemonDetails: (Int) -> Unit,
    onRetry: () -> Unit = {},
) {
    ScreenScaffoldContainer(
        screenTitle = stringResource(R.string.title_home),
        leftActionProperties = null,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(horizontal = MaterialTheme.dimensions.medium),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium),
        ) {
            when(uiState) {
                is PokemonUiState.Success -> {
                    PokemonContent(
                        pokemonList = uiState.pokemonList,
                        navigateToDetails = navigateToPokemonDetails
                    )
                }

                is PokemonUiState.Error -> {
                    EmptyContainer(
                        title = uiState.error.asString(),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = MaterialTheme.dimensions.medium),
                        buttonText = stringResource(R.string.retry),
                        buttonOnClick = onRetry
                    )
                }

                is PokemonUiState.Loading ->  FullScreenLoadingIndicator()
            }
        }
    }
}

@Composable
private fun PokemonContent(
    pokemonList: List<Pokedex>,
    navigateToDetails: (Int) -> Unit,
) {
    if (pokemonList.isEmpty()) {
        EmptyContainer(
            title = stringResource(R.string.empty_pokemon),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = MaterialTheme.dimensions.medium),
        )
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.large),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.large),
        ) {
            items(items = pokemonList, key = { pokedex -> pokedex.pokemonId }) { pokedex ->
                PokemonCard(
                    pokedex = pokedex,
                    navigateToDetails = navigateToDetails
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PokemonHomeScreenPreview() {
    val dummyPokedex = listOf(
        Pokedex(
            name = "Bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            pokemonId = 1
        ),
        Pokedex(
            name = "Charmander",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            pokemonId = 4
        ),
        Pokedex(
            name = "Squirtle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            pokemonId = 7
        ),
        Pokedex(
            name = "Pikachu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            pokemonId = 25
        )
    ).toImmutableList()

    PokedexTheme {
        PokemonHomeScreen(
            uiState = PokemonUiState.Success(pokemonList = dummyPokedex),
            navigateToPokemonDetails = {}
        )
    }
}