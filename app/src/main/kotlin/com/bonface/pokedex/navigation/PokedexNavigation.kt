package com.bonface.pokedex.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.bonface.pokedex.ui.detailscreen.PokemonDetailsScreen
import com.bonface.pokedex.ui.homescreen.PokemonHomeScreen
import com.bonface.pokedex.viewmodel.PokemonDetailsViewModel
import com.bonface.pokedex.viewmodel.PokemonViewModel

/**
 * Bundles home nav host
 *
 * @param navController
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun PokedexNavigation(
    navController: NavHostController,
    onClose: () -> Unit = {},
) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = NavigationRoutes.Home) {
            composable(route = NavigationRoutes.Home) {
                val viewModel: PokemonViewModel = hiltViewModel()
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                PokemonHomeScreen()
            }

            composable(
                route = NavigationRoutes.Details,
                arguments = listOf(navArgument("pokemonId") { type = NavType.IntType })
            ) { backStackEntry ->
                val pokemonId = backStackEntry.arguments?.getInt("pokemonId") ?: return@composable
                val viewModel: PokemonDetailsViewModel = hiltViewModel()

                LaunchedEffect(pokemonId) {
                    viewModel.getPokemonDetails(pokemonId)
                }

                PokemonDetailsScreen(
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}
