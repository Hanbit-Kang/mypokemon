package com.hanbitkang.feature.pokemon.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hanbitkang.core.designsystem.MpNavigationDestination
import com.hanbitkang.feature.pokemon.PokemonRoute

object PokemonDestination : MpNavigationDestination {
    override val route = "pokemon_route"
    override val destination = "pokemon_destination"
}

fun NavGraphBuilder.pokemonGraph() {
    composable(route = PokemonDestination.route) {
        PokemonRoute()
    }
}