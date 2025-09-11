package com.bonface.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonface.consumerapi.data.model.Pokemon
import com.bonface.consumerapi.di.IoDispatcher
import com.bonface.consumerapi.domain.Failure
import com.bonface.consumerapi.domain.Result
import com.bonface.consumerapi.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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
                    is Result.Success -> _uiState.value = PokemonUiState.Success(result.data.results)
                    is Result.Error -> _uiState.value = PokemonUiState.Error(result.error)
                }
            }
        }
    }
}

sealed interface PokemonUiState {
    data object Loading : PokemonUiState
    data class Error(val error: Failure.Network) : PokemonUiState
    data class Success(val pokemonList: List<Pokemon>) : PokemonUiState
}
