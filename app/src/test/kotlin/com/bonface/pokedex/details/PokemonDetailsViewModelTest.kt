package com.bonface.pokedex.details

import app.cash.turbine.test
import com.bonface.consumerapi.domain.Failure
import com.bonface.consumerapi.repository.PokemonRepository
import com.bonface.pokedex.utils.BaseTest
import com.bonface.pokedex.utils.MainDispatcherRule
import com.bonface.pokedex.utils.TestCreationUtils.pokedexDetails
import com.bonface.pokedex.utils.TestCreationUtils.samplePokemonDetails
import com.bonface.pokedex.utils.TestCreationUtils.samplePokemonDetailsErrorResponse
import com.bonface.pokedex.utils.TestCreationUtils.samplePokemonSpecies
import com.bonface.pokedex.viewmodel.DetailsUiState
import com.bonface.pokedex.viewmodel.PokemonDetailsViewModel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
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
class PokemonDetailsViewModelTest: BaseTest() {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()
    private val dispatcher = UnconfinedTestDispatcher()

    private val repository = mockk<PokemonRepository>(relaxed = true)

    private lateinit var viewModel: PokemonDetailsViewModel

    @Before
    override fun setup() {
        super.setup()
        viewModel = PokemonDetailsViewModel(repository, dispatcher)
    }

    @After
    override fun teardown() {
        clearAllMocks()
    }

    @Test
    fun `Given that viewmodel getPokemonDetails has been initiated, make sure that we show a loading state`() = runTest(dispatcher) {
        // WHEN
        viewModel.getPokemonDetails(1)
        //THEN
        viewModel.uiState.test {
            assertEquals(DetailsUiState.Loading, awaitItem())
            assert(viewModel.uiState.value is DetailsUiState.Loading)
        }
    }

    @Test
    fun `Given that getPokemonDetails api call return success, make sure that we show a success state`() = runTest {
        // GIVEN
        coEvery { repository.getPokemonDetails(1) } returns flowOf(samplePokemonDetails())
        coEvery { repository.getPokemonSpeciesDetails(1) } returns flowOf(samplePokemonSpecies())
        // WHEN
        viewModel.getPokemonDetails(1)
        //THEN
        viewModel.uiState.test {
            assert(viewModel.uiState.value is DetailsUiState.Success)
            assertEquals(DetailsUiState.Success(pokedexDetails()), awaitItem())
            assertNotNull((viewModel.uiState.value as DetailsUiState.Success).details)
            assertEquals((viewModel.uiState.value as DetailsUiState.Success).details?.pokemonId, pokedexDetails().pokemonId)
        }
    }

    @Test
    fun `Given that getPokemonDetails api call returns an error, make sure that we emit error state`() = runTest {
        // GIVEN
        coEvery { repository.getPokemonDetails(1) } returns flowOf(samplePokemonDetailsErrorResponse())
        coEvery { repository.getPokemonSpeciesDetails(1) } returns flowOf(samplePokemonSpecies())

        // WHEN
        viewModel.getPokemonDetails(1)
        //THEN
        viewModel.uiState.test {
            assert(viewModel.uiState.value is DetailsUiState.Error)
            assertEquals(DetailsUiState.Error(Failure.Network.RequestTimeout), awaitItem())
            assertEquals((viewModel.uiState.value as DetailsUiState.Error).error, Failure.Network.RequestTimeout)
        }
    }
}
