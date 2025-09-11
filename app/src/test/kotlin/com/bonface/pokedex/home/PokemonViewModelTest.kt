package com.bonface.pokedex.home

import app.cash.turbine.test
import com.bonface.consumerapi.mappers.toPokedex
import com.bonface.consumerapi.repository.PokemonRepository
import com.bonface.pokedex.helpers.UiText
import com.bonface.pokedex.utils.BaseTest
import com.bonface.pokedex.utils.MainDispatcherRule
import com.bonface.pokedex.utils.TestCreationUtils.getPokemon
import com.bonface.pokedex.utils.TestCreationUtils.samplePokemonErrorResponse
import com.bonface.pokedex.utils.TestCreationUtils.samplePokemonResponse
import com.bonface.pokedex.viewmodel.PokemonUiState
import com.bonface.pokedex.viewmodel.PokemonViewModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PokemonViewModelTest : BaseTest() {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()
    private val dispatcher = UnconfinedTestDispatcher()

    private val repository = mockk<PokemonRepository>(relaxed = true)

    private lateinit var viewModel: PokemonViewModel

    @Before
    override fun setup() {
        super.setup()
        viewModel = PokemonViewModel(repository, dispatcher)
    }

    @After
    override fun teardown() {
        clearAllMocks()
    }

    @Test
    fun `Given that viewmodel getPokemon has been initiated, make sure that we show a loading state`() = runTest {
        // WHEN
        viewModel.getPokemon()

        // THEN
        viewModel.uiState.test {
            assertEquals(PokemonUiState.Loading, awaitItem())
            assert(viewModel.uiState.value is PokemonUiState.Loading)
        }
    }

    @Test
    fun `Given that getPokemon api call return success, make sure that we show a success state`() = runTest {
        // GIVEN
        coEvery { repository.getPokemon() } returns flowOf(samplePokemonResponse())

        // WHEN
        viewModel.getPokemon()

        // THEN
        viewModel.uiState.test {
            val state = awaitItem()
            assert(state is PokemonUiState.Success)
            assertEquals(
                getPokemon().results.map { it.toPokedex() }.toImmutableList(),
                (state as PokemonUiState.Success).pokemonList
            )
            assertNotNull(viewModel.uiState.value)
        }
    }

    @Test
    fun `Given that getPokemon api call returns an error, make sure that we emit error state`() = runTest {
        // GIVEN
        coEvery { repository.getPokemon() } returns flowOf(samplePokemonErrorResponse())

        // WHEN
        viewModel.getPokemon()

        // THEN
        viewModel.uiState.test {
            val state = awaitItem()
            assert(state is PokemonUiState.Error)

            val error = (state as PokemonUiState.Error).error
            assert(error is UiText.DynamicString)
            assertEquals("Server error, resource not available", (error as UiText.DynamicString).value)
        }
    }
}
