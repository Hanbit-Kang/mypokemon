package com.hanbitkang.feature.pokemon.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hanbitkang.core.designsystem.MpNavigationDestination
import com.hanbitkang.feature.pokemon.PokemonRoute

object PokemonDestination : MpNavigationDestination {
    override val route = "pokemon_route"
    override val destination = "pokemon_destination"
}

fun NavGraphBuilder.pokemonGraph(
    navigateToPokemonDetail: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = PokemonDestination.route,
        startDestination = PokemonDestination.destination
    ) {
        composable(route = PokemonDestination.destination) {
            PokemonRoute(
                navigateToPokemonDetail = navigateToPokemonDetail
            )
        }
        nestedGraphs()
    }
}