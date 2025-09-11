package com.bonface.pokedex.utils

import com.bonface.consumerapi.data.model.Ability
import com.bonface.consumerapi.data.model.AbilityDetails
import com.bonface.consumerapi.data.model.DetailedPokedexResponse
import com.bonface.consumerapi.data.model.Pokemon
import com.bonface.consumerapi.data.model.PokemonResponse
import com.bonface.consumerapi.data.model.Species
import com.bonface.consumerapi.data.model.FlavorTextEntry
import com.bonface.consumerapi.data.model.Habitat
import com.bonface.consumerapi.data.model.Language
import com.bonface.consumerapi.data.model.Name
import com.bonface.consumerapi.data.model.PokedexDetails
import com.bonface.consumerapi.data.model.PokemonSpeciesResponse
import com.bonface.consumerapi.data.model.PokemonTypes
import com.bonface.consumerapi.data.model.Shape
import com.bonface.consumerapi.data.model.SpeciesColor
import com.bonface.consumerapi.data.model.Sprites
import com.bonface.consumerapi.data.model.Stat
import com.bonface.consumerapi.data.model.StatDetails
import com.bonface.consumerapi.data.model.Type
import com.bonface.consumerapi.data.model.Variety
import com.bonface.consumerapi.domain.Failure
import com.bonface.consumerapi.domain.Result
import com.bonface.consumerapi.mappers.toPokedexDetails

object TestCreationUtils {

    fun getPokemon(): PokemonResponse {
        return PokemonResponse(
            count = 2,
            next = "https://pokeapi.co/api/v2/pokemon?offset=100&limit=100",
            previous = null,
            results = listOf(Pokemon(name = "bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"), Pokemon(name = "ivysaur", url = "https://pokeapi.co/api/v2/pokemon/2/"))
        )
    }

    private fun getPokemonDetails(): DetailedPokedexResponse {
        return DetailedPokedexResponse(
            abilities = listOf(Ability(ability = AbilityDetails(name= "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"), isHidden = false, slot = 1)),
            baseExperience = 64,
            height = 7,
            id = 1,
            name = "bulbasaur",
            species = Species("bulbasaur", "https://pokeapi.co/api/v2/pokemon-species/1/"),
            sprites = Sprites(),
            stats = listOf(
                Stat(45, 0, StatDetails("hp", "https://pokeapi.co/api/v2/stat/1/")),
                Stat(49, 0, StatDetails("attack", "https://pokeapi.co/api/v2/stat/2/"))
            ),
            weight = 69,
            types = listOf(
                PokemonTypes(1, Type("grass", "https://pokeapi.co/api/v2/type/12/")),
                PokemonTypes(2, Type("poison", "https://pokeapi.co/api/v2/type/4/"))
            )
        )
    }

    private fun getPokemonSpecies(): PokemonSpeciesResponse {
        return PokemonSpeciesResponse(
            color = SpeciesColor("green", "https://pokeapi.co/api/v2/pokemon-color/5/"),
            flavorTextEntries = listOf(
                FlavorTextEntry(
                    "A strange seed was\nplanted on its\nback at birth.\nThe plant sprouts\nand grows with\nthis POKéMON.",
                    Language("en", "https://pokeapi.co/api/v2/language/9/")
                )
            ),
            habitat = Habitat("grassland", "https://pokeapi.co/api/v2/pokemon-habitat/3/"),
            id = 1,
            isBaby = false,
            name = "bulbasaur",
            names = listOf(Name(Language("roomaji", "https://pokeapi.co/api/v2/language/2/"), "Fushigidane")),
            shape = Shape("quadruped", "https://pokeapi.co/api/v2/pokemon-shape/8/"),
            varieties = listOf(
                Variety(true, Pokemon("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"))
            )
        )
    }

    fun pokedexDetails(): PokedexDetails {
        val pairedResult = Pair(getPokemonDetails(), getPokemonSpecies())
        return pairedResult.toPokedexDetails()
    }

    fun samplePokemonResponse(): Result<PokemonResponse, Failure.Network> {
        return Result.Success(getPokemon())
    }

    fun samplePokemonDetails(): Result<DetailedPokedexResponse, Failure.Network> {
        return Result.Success(getPokemonDetails())
    }

    fun samplePokemonSpecies(): Result<PokemonSpeciesResponse, Failure.Network> {
        return Result.Success(getPokemonSpecies())
    }

    fun samplePokemonErrorResponse(): Result<PokemonResponse, Failure.Network> {
        return Result.Error(Failure.Network.ServerError(message = "Server error, resource not available"))
    }

    fun samplePokemonDetailsErrorResponse(): Result<DetailedPokedexResponse, Failure.Network> {
        return Result.Error(Failure.Network.RequestTimeout)
    }

}



