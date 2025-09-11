package com.bonface.consumerapi.repository

import com.bonface.consumerapi.data.model.DetailedPokedexResponse
import com.bonface.consumerapi.data.model.PokemonResponse
import com.bonface.consumerapi.data.model.PokemonSpeciesResponse
import com.bonface.consumerapi.domain.Failure
import com.bonface.consumerapi.domain.Result
import kotlinx.coroutines.flow.Flow

/**
 * Repository responsible for fetching Pokémon-related data from the network.
 *
 * Provides functions to retrieve:
 *  - A list of Pokémon
 *  - Detailed Pokémon data by ID
 *  - Pokémon species data by ID
 *
 * Responses are wrapped in [Result] to handle both success and network failures.
 */
interface PokemonRepository {

    /**
     * Fetches a paginated list of Pokémon.
     *
     * @return [Flow] emitting a [Result] containing either a [PokemonResponse] on success
     * or [Failure.Network] on failure.
     */
    suspend fun getPokemon(): Flow<Result<PokemonResponse, Failure.Network>>

    /**
     * Fetches detailed information for a specific Pokémon.
     *
     * @param pokemonId ID of the Pokémon to fetch details for.
     * @return [Flow] emitting a [Result] containing either a [DetailedPokedexResponse] on success
     * or [Failure.Network] on failure.
     */
    suspend fun getPokemonDetails(pokemonId: Int): Flow<Result<DetailedPokedexResponse, Failure.Network>>

    /**
     * Fetches species-specific information for a specific Pokémon.
     *
     * @param pokemonId ID of the Pokémon to fetch species details for.
     * @return [Flow] emitting a [Result] containing either a [PokemonSpeciesResponse] on success
     * or [Failure.Network] on failure.
     */
    suspend fun getPokemonSpeciesDetails(pokemonId: Int): Flow<Result<PokemonSpeciesResponse, Failure.Network>>
}