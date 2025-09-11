package com.bonface.pokedex.ui.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.consumerapi.data.model.Pokedex
import com.bonface.designsystem.components.buttons.ShadowIconButton
import com.bonface.designsystem.components.empty.EmptyContainer
import com.bonface.designsystem.components.loading.FullScreenLoadingIndicator
import com.bonface.designsystem.components.menu.MenuActionStyle
import com.bonface.designsystem.components.menu.MenuActionStyleDefaults
import com.bonface.designsystem.components.scaffold.ScreenScaffoldContainer
import com.bonface.designsystem.components.search.SearchInputField
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.extensions.hideKeyboardAndClearFocusOnScrollDown
import com.bonface.designsystem.extensions.hideSearchOnScrollDown
import com.bonface.designsystem.theme.PokedexTheme
import com.bonface.pokedex.R
import com.bonface.pokedex.viewmodel.PokemonUiState
import kotlinx.collections.immutable.toImmutableList

@Composable
fun PokemonHomeScreen(
    uiState: PokemonUiState,
    searchQuery: String,
    showSearch: Boolean,
    navigateToPokemonDetails: (Int) -> Unit,
    onSearchValueChange: (String) -> Unit = {},
    onShowSearchChange: (Boolean) -> Unit = {},
    onRetry: () -> Unit = {},
) {

    ScreenScaffoldContainer(
        screenTitle = stringResource(R.string.title_home),
        leftActionProperties = null,
        rightActions = searchMenuIcon(
            showSearch = showSearch,
            onSearchClick = { onShowSearchChange(true) },
            onCloseClick = { onShowSearchChange(false) }
        )
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
                    if (uiState.pokemonList.isEmpty()) {
                        EmptyContainer(
                            title = stringResource(R.string.empty_pokemon),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = MaterialTheme.dimensions.medium),
                        )
                    } else {
                        PokemonContent(
                            pokemonList = uiState.pokemonList,
                            searchQuery = searchQuery,
                            onSearchValueChange = onSearchValueChange,
                            navigateToDetails = navigateToPokemonDetails,
                            showSearch = showSearch,
                            onHideSearch = { onShowSearchChange(false) },
                        )
                    }
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
    searchQuery: String,
    onSearchValueChange: (String) -> Unit,
    navigateToDetails: (Int) -> Unit,
    showSearch: Boolean,
    onHideSearch: () -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    val modifier = Modifier
        .hideKeyboardAndClearFocusOnScrollDown(keyboardController, focusManager)
        .hideSearchOnScrollDown { onHideSearch() }

    Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.medium)) {
        AnimatedVisibility(
            visible = showSearch,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            SearchInputField(
                modifier = Modifier.focusRequester(focusRequester),
                placeholder = stringResource(R.string.search_pokemon),
                value = searchQuery,
                onSearchValueChange = onSearchValueChange,
                onDone = { keyboardController?.hide() },
            )
        }

        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.large),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.large),
        ) {
            items(items = pokemonList, key = { pokedex -> pokedex.pokemonId }) { pokedex ->
                PokemonCard(
                    pokedex = pokedex,
                    searchQuery = searchQuery,
                    navigateToDetails = navigateToDetails
                )
            }
        }
    }
}

@Composable
private fun searchMenuIcon(
    showSearch: Boolean,
    onSearchClick: () -> Unit,
    onCloseClick: () -> Unit,
): List<@Composable (MenuActionStyle) -> Unit> {
    val menuActionStyle = MenuActionStyleDefaults.defaultStyle(
        iconTint = MaterialTheme.colorScheme.onBackground
    )

    return listOf {
        ShadowIconButton(
            icon = if (showSearch) {
                painterResource(com.bonface.designsystem.R.drawable.ic_close) // close icon
            } else {
                painterResource(com.bonface.designsystem.R.drawable.ic_search_normal) // search icon
            },
            iconTint = Color.Unspecified,
            containerColor = menuActionStyle.containerColor,
            contentDescription = if (showSearch) {
                stringResource(com.bonface.designsystem.R.string.content_description_action_close)
            } else {
                stringResource(R.string.search_pokemon)
            },
            enabled = true,
            onClick = if (showSearch) onCloseClick else onSearchClick,
        )
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
    val searchQuery by remember { mutableStateOf("Bulbar") }
    PokedexTheme {
        PokemonHomeScreen(
            uiState = PokemonUiState.Success(pokemonList = dummyPokedex),
            searchQuery = searchQuery,
            showSearch = true,
            navigateToPokemonDetails = {}
        )
    }
}