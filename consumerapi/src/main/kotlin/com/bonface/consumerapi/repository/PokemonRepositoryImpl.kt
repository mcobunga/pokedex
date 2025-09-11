package com.bonface.consumerapi.repository

import com.bonface.consumerapi.data.api.PokemonApiService
import com.bonface.consumerapi.data.model.DetailedPokedexResponse
import com.bonface.consumerapi.data.model.PokemonResponse
import com.bonface.consumerapi.data.model.PokemonSpeciesResponse
import com.bonface.consumerapi.domain.ErrorHandler
import com.bonface.consumerapi.domain.Failure
import com.bonface.consumerapi.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonApiService: PokemonApiService,
    private val errorHandler: ErrorHandler
): PokemonRepository {
    override suspend fun getPokemon(): Flow<Result<PokemonResponse, Failure.Network>> = flow {
        try {
            val result = pokemonApiService.getPokemon()
            emit(handleResponse(result))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(errorHandler.handleException(e)))
        }
    }

    override suspend fun getPokemonDetails(pokemonId: Int): Flow<Result<DetailedPokedexResponse, Failure.Network>> = flow {
        try {
            val result = pokemonApiService.getPokemonDetails(pokemonId)
            emit(handleResponse(result))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(errorHandler.handleException(e)))
        }
    }

    override suspend fun getPokemonSpeciesDetails(pokemonId: Int): Flow<Result<PokemonSpeciesResponse, Failure.Network>> = flow {
        try {
            val result = pokemonApiService.getPokemonSpeciesDetails(pokemonId)
            emit(handleResponse(result))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Result.Error(errorHandler.handleException(e)))
        }
    }

    private fun <T> handleResponse(response: Response<T>): Result<T, Failure.Network> {
        return if (response.isSuccessful) {
            response.body()?.let { Result.Success(it) }
                ?: Result.Error(Failure.Network.ServerError("Empty body"))
        } else {
            Result.Error(Failure.Network.ServerError(errorHandler.getServerSideErrorMessage(response)))
        }
    }
}