package com.bonface.pokedex.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bonface.consumerapi.data.model.Pokedex
import com.bonface.consumerapi.di.IoDispatcher
import com.bonface.consumerapi.domain.Result
import com.bonface.consumerapi.mappers.toPokedex
import com.bonface.consumerapi.repository.PokemonRepository
import com.bonface.designsystem.helpers.DEBOUNCE_TIME_300
import com.bonface.designsystem.helpers.EMPTY
import com.bonface.designsystem.helpers.STOP_TIMEOUT_MILLIS
import com.bonface.pokedex.helpers.UiText
import com.bonface.pokedex.helpers.toUiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _originalUiStateFlow = MutableStateFlow<PokemonUiState>(PokemonUiState.Loading)

    private val _searchQuery = MutableStateFlow(EMPTY)
    val searchQuery = _searchQuery.asStateFlow()

    private val _showSearch = MutableStateFlow(false)
    val showSearch = _showSearch.asStateFlow()

    val uiState: StateFlow<PokemonUiState> =
        combine(
            _searchQuery.debounce(DEBOUNCE_TIME_300).distinctUntilChanged(),
            _originalUiStateFlow
        ) { query, originalState ->
            if (query.isBlank()) {
                originalState
            } else {
                originalState.filterByQuery(query)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(STOP_TIMEOUT_MILLIS),
            initialValue = PokemonUiState.Loading,
        )


    init {
        getPokemon()
    }

    fun getPokemon() {
        viewModelScope.launch(ioDispatcher) {
            repository.getPokemon().collect { result ->
                when(result) {
                    is Result.Success -> {
                        val pokemons = result.data.results.map { it.toPokedex() }.toImmutableList()
                        _originalUiStateFlow.value = PokemonUiState.Success(pokemons, false)
                    }
                    is Result.Error -> _originalUiStateFlow.value = PokemonUiState.Error(result.error.toUiText())
                }
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun onShowSearchInputChange(show: Boolean) {
        _showSearch.value = show
    }

    fun onPullToRefresh() {
        val current = _originalUiStateFlow.value
        if (current is PokemonUiState.Success) {
            _originalUiStateFlow.value = current.copy(isRefreshing = true)
        }
        getPokemon()
    }

    private fun PokemonUiState.filterByQuery(query: String): PokemonUiState {
        return when (this) {
            is PokemonUiState.Success -> {
                val filtered = pokemonList.filter { pokedex ->
                    pokedex.name.contains(query, ignoreCase = true)
                }.toImmutableList()
                PokemonUiState.Success(filtered)
            }
            else -> this // Loading and Error are unaffected
        }
    }
}

sealed interface PokemonUiState {
    data object Loading : PokemonUiState
    data class Error(val error: UiText) : PokemonUiState
    data class Success(
        val pokemonList: ImmutableList<Pokedex>,
        val isRefreshing: Boolean = false
    ) : PokemonUiState
}
