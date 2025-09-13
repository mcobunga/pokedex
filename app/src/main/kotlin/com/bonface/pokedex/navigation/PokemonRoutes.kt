package com.bonface.pokedex.navigation


import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.bonface.pokedex.extensions.appendArguments
import com.bonface.pokedex.extensions.replaceRoute

const val POKEDEX_KEY = "pokedexId"

/**
 * Pokemon navigation routes
 *
 * @property route
 * @property navArguments
 */

enum class PokemonRoutes(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    Home("home"),
    Details("details", listOf(navArgument(POKEDEX_KEY) { type = androidx.navigation.NavType.IntType }));

    val deepLink: String = route.appendArguments(navArguments)

    fun createRoute(params: Int): String {
        return replaceRoute(deepLink, params, navArguments, encode = false)
    }
}