package com.bonface.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonface.consumerapi.data.model.Pokedex
import com.bonface.consumerapi.di.IoDispatcher
import com.bonface.consumerapi.domain.Result
import com.bonface.consumerapi.mappers.toPokedex
import com.bonface.consumerapi.repository.PokemonRepository
import com.bonface.pokedex.helpers.UiText
import com.bonface.pokedex.helpers.toUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokemonUiState>(PokemonUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getPokemon()
    }

    fun getPokemon() {
        viewModelScope.launch(ioDispatcher) {
            repository.getPokemon().collect { result ->
                when(result) {
                    is Result.Success -> {
                        val pokemons = result.data.results.map { it.toPokedex() }.toImmutableList()
                        _uiState.value = PokemonUiState.Success(pokemons)
                    }
                    is Result.Error -> _uiState.value = PokemonUiState.Error(result.error.toUiText())
                }
            }
        }
    }
}

sealed interface PokemonUiState {
    data object Loading : PokemonUiState
    data class Error(val error: UiText) : PokemonUiState
    data class Success(val pokemonList: ImmutableList<Pokedex>) : PokemonUiState
}
