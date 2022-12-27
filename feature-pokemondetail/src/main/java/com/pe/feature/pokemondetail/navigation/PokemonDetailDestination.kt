package com.pe.feature.pokemondetail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hanbitkang.core.designsystem.MpNavigationDestination

object PokemonDetailDestination : MpNavigationDestination {
    const val pokemonIdArg = "pokemonId"
    override val route = "pokemon_detail_route/{$pokemonIdArg}"
    override val destination = "pokemon_detail_destination"
}

fun NavGraphBuilder.pokemonDetailGraph() {
    composable(
        route = PokemonDetailDestination.route,
        arguments = listOf(
            navArgument(PokemonDetailDestination.pokemonIdArg) { type = NavType.IntType }
        )
    ) {
        // TODO: PokemonDetailRoute()
    }
}