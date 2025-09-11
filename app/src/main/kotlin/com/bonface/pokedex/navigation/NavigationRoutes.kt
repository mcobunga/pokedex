package com.bonface.pokedex.navigation

import androidx.navigation.NamedNavArgument

object NavigationRoutes {
    const val Home = "home"
    const val Details = "details"
    const val DetailsWithArg = "details/{pokemonId}"

    fun details(pokemonId: Int) = "$Details/$pokemonId"
}


private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}
