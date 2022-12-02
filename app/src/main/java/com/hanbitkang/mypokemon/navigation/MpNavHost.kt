package com.hanbitkang.mypokemon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.hanbitkang.feature.favorite.navigation.favoriteGraph
import com.hanbitkang.feature.pokemon.navigation.PokemonDestination
import com.hanbitkang.feature.pokemon.navigation.pokemonGraph

@Composable
fun MpNavHost(
    navController: NavHostController,
    startDestination: String = PokemonDestination.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        pokemonGraph()
        favoriteGraph()
    }
}