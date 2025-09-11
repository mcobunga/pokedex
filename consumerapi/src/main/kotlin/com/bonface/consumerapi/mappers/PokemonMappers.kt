package com.bonface.consumerapi.mappers

import com.bonface.consumerapi.data.model.DetailedPokedexResponse
import com.bonface.consumerapi.data.model.Pokedex
import com.bonface.consumerapi.data.model.PokedexDetails
import com.bonface.consumerapi.data.model.Pokemon
import com.bonface.consumerapi.data.model.PokemonSpeciesResponse
import com.bonface.consumerapi.utils.getPokemonHeight
import com.bonface.consumerapi.utils.getPokemonId
import com.bonface.consumerapi.utils.getPokemonImageUrl
import com.bonface.consumerapi.utils.getPokemonWeight

fun Pokemon.toPokedex(): Pokedex {
    val pokemonId = url.getPokemonIdFromUrl()
    return Pokedex(
        name = name,
        imageUrl = getPokemonImageUrl(pokemonId),
        pokemonId = pokemonId,
    )
}

fun Pair<DetailedPokedexResponse, PokemonSpeciesResponse>.toPokedexDetails(): PokedexDetails {
    val pokemonId = this.first.species.url.getPokemonIdFromUrl()
    return PokedexDetails(
        pokemonId = getPokemonId(pokemonId),
        name = this.first.species.name,
        about = this.second.flavorTextEntries.firstOrNull()?.flavorText?.replace("\n", " ")?.trim().orEmpty(),
        weight = getPokemonWeight(this.first.weight),
        height = getPokemonHeight(this.first.height),
        color = this.second.color.name,
        imageUrl = getPokemonImageUrl(pokemonId),
        abilities = this.first.abilities.map { it.ability.name to it.isHidden },
        stats = this.first.stats.map { it.stat.name to it.baseStat },
        types = this.first.types.map { it.pokemonType.name }
    )
}

fun String.getPokemonIdFromUrl(): Int {
    return split("/").lastOrNull { it.isNotBlank() }
        ?.toIntOrNull()
        ?: throw IllegalArgumentException("Invalid Pokemon URL: $this")
}
