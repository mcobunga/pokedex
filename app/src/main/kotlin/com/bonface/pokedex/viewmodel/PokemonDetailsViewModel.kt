package com.bonface.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonface.consumerapi.data.model.PokedexDetails
import com.bonface.consumerapi.di.IoDispatcher
import com.bonface.consumerapi.domain.Result
import com.bonface.consumerapi.mappers.toPokedexDetails
import com.bonface.consumerapi.repository.PokemonRepository
import com.bonface.pokedex.helpers.UiText
import com.bonface.pokedex.helpers.toUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow<PokemonDetailsUiState>(PokemonDetailsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getPokemonDetails(pokemonId: Int) {
        viewModelScope.launch(ioDispatcher) {
            val detailsFlow = repository.getPokemonDetails(pokemonId)
            val speciesFlow = repository.getPokemonSpeciesDetails(pokemonId)

            combine(detailsFlow, speciesFlow) { details, species ->
                when {
                    details is Result.Success && species is Result.Success -> {
                        val result = Pair(details.data, species.data).toPokedexDetails()
                        PokemonDetailsUiState.Success(result)
                    }
                    details is Result.Error -> PokemonDetailsUiState.Error(details.error.toUiText())
                    species is Result.Error -> PokemonDetailsUiState.Error(species.error.toUiText())
                    else -> PokemonDetailsUiState.Loading
                }
            }.collect { state -> _uiState.value = state }
        }
    }
}

sealed interface PokemonDetailsUiState {
    data object Loading : PokemonDetailsUiState
    data class Error(val error: UiText) : PokemonDetailsUiState
    data class Success(val details: PokedexDetails) : PokemonDetailsUiState
}