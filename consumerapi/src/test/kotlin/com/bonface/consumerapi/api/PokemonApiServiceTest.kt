package com.bonface.consumerapi.api

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class PokemonApiServiceTest : MockPokemonApiServiceTest() {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    override fun before() {
        super.before()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    override fun after() {
        super.after()
        Dispatchers.resetMain()
    }

    @Test
    fun `fetch pokemon list returns expected response`() = runTest {
        val response = pokemonApiService.getPokemon()
        assertTrue(response.isSuccessful)
        val body = response.body()!!
        assertEquals(2, body.count)
        assertEquals(2, body.results.size)
        assertEquals("bulbasaur", body.results.first().name)
        assertEquals("https://pokeapi.co/api/v2/pokemon/1/", body.results.first().url)
    }

    @Test
    fun `fetch pokemon details returns expected response`() = runTest {
        val response = pokemonApiService.getPokemonDetails(1)
        assertTrue(response.isSuccessful)
        val body = response.body()!!
        assertEquals("bulbasaur", body.name)
        assertEquals("overgrow", body.abilities.first().ability.name)
        assertEquals(69, body.weight)
        assertEquals(7, body.height)
    }

    @Test
    fun `fetch pokemon species details returns expected response`() = runTest {
        val response = pokemonApiService.getPokemonSpeciesDetails(1)
        assertTrue(response.isSuccessful)
        val body = response.body()!!
        assertEquals("bulbasaur", body.name)
        assertEquals("green", body.color.name)
        assertEquals(1, body.id)
        assertEquals("grassland", body.habitat.name)
    }
}