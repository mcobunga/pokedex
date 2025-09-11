package com.bonface.consumerapi.data.model

data class PokedexDetails(
    val pokemonId: String,
    val name: String,
    val about: String,
    val weight: String,
    val height: String,
    val color: String,
    val imageUrl: String,
    val abilities: List<Pair<String, Boolean>>,
    val stats: List<Pair<String, Int>>,
    val types: List<String>,
)
