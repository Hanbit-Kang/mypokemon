package com.hanbitkang.mypokemon.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hanbitkang.core_designsystem.icon.MpIcons
import com.hanbitkang.core_navigation.MpNavigationDestination
import com.hanbitkang.feature_favorite.navigation.FavoriteDestination
import com.hanbitkang.feature_pokemon.navigation.PokemonDestination
import com.hanbitkang.mypokemon.R
import com.hanbitkang.mypokemon.navigation.TopLevelDestination

@Composable
fun rememberMpAppState(
    navController: NavHostController = rememberNavController()
) : MpAppState {
    return remember(navController) {
        MpAppState(navController)
    }
}

@Stable
class MpAppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            PokemonDestination.route,
            PokemonDestination.destination,
            MpIcons.BaselineCrueltyFree,
            MpIcons.OutlineCrueltyFree,
            com.hanbitkang.feature_favorite.R.string.my_favorites
        ),
        TopLevelDestination(
            FavoriteDestination.route,
            FavoriteDestination.destination,
            MpIcons.Bookmark,
            MpIcons.BookmarkBorder,
            com.hanbitkang.feature_pokemon.R.string.pokemon_list
        )
    )
}