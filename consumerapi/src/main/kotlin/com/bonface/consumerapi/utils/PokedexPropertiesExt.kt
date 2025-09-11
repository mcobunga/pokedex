package com.bonface.consumerapi.utils

import java.util.Locale


fun getPokemonImageUrl(pokemonId: Int) = buildString {
    append("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/shiny/")
    append(pokemonId)
    append(".png")
}

fun getPokemonId(pokemonId: Int): String = String.format(Locale.getDefault(), "#%03d", pokemonId)

fun getPokemonWeight(weight: Int): String = String.format(Locale.getDefault(), "%.1f KG", weight.toFloat() / 10)

fun getPokemonHeight(height: Int): String = String.format(Locale.getDefault(), "%.1f M", height.toFloat() / 10)