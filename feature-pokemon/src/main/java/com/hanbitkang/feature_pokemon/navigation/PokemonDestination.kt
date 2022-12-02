package com.hanbitkang.feature_pokemon.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hanbitkang.core.navigation.MpNavigationDestination
import com.hanbitkang.feature_pokemon.PokemonScreen

object PokemonDestination : MpNavigationDestination {
    override val route = "pokemon_route"
    override val destination = "pokemon_destination"
}

fun NavGraphBuilder.pokemonGraph() {
    composable(route = PokemonDestination.route) {
        PokemonScreen()
    }
}