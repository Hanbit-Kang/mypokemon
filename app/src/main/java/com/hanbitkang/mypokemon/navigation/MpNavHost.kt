package com.hanbitkang.mypokemon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hanbitkang.core.designsystem.MpNavigationDestination
import com.hanbitkang.feature.favorite.navigation.FavoriteDestination
import com.hanbitkang.feature.favorite.navigation.favoriteGraph
import com.hanbitkang.feature.pokemon.navigation.pokemonGraph
import com.hanbitkang.feature.detail.navigation.PokemonDetailDestination
import com.hanbitkang.feature.detail.navigation.pokemonDetailGraph

@Composable
fun MpNavHost(
    navController: NavHostController,
    onNavigateToDestination: (MpNavigationDestination, String) -> Unit,
    onClickBackButton: () -> Unit,
    startDestination: String = FavoriteDestination.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        favoriteGraph(
            navigateToPokemonDetail = {
                onNavigateToDestination(
                    PokemonDetailDestination, PokemonDetailDestination.createNavigationRoute(it)
                )
            },
            nestedGraphs = {
                pokemonDetailGraph(onClickBackButton = onClickBackButton)
            }
        )
        pokemonGraph(
            navigateToPokemonDetail = {
                onNavigateToDestination(
                    PokemonDetailDestination, PokemonDetailDestination.createNavigationRoute(it)
                )
            },
            nestedGraphs = {
                pokemonDetailGraph(onClickBackButton = onClickBackButton)
            }
        )
    }
}