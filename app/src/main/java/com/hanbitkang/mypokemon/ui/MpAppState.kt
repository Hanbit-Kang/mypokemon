package com.hanbitkang.mypokemon.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hanbitkang.core.designsystem.MpNavigationDestination
import com.hanbitkang.core.designsystem.icon.MpIcons
import com.hanbitkang.feature.favorite.navigation.FavoriteDestination
import com.hanbitkang.feature.pokemon.navigation.PokemonDestination
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
            FavoriteDestination.route,
            FavoriteDestination.destination,
            MpIcons.Bookmark,
            MpIcons.BookmarkBorder,
            com.hanbitkang.feature.favorite.R.string.my_favorites
        ),
        TopLevelDestination(
            PokemonDestination.route,
            PokemonDestination.destination,
            MpIcons.BaselineCrueltyFree,
            MpIcons.OutlineCrueltyFree,
            com.hanbitkang.feature.pokemon.R.string.pokemon_list
        )
    )

    fun navigate(
        destination: MpNavigationDestination,
        route: String? = null
    ) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }

                launchSingleTop = true
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onClickBackButton() {
        navController.navigateUp()
    }
}