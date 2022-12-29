package com.hanbitkang.feature.favorite.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.hanbitkang.core.designsystem.MpNavigationDestination
import com.hanbitkang.feature.favorite.FavoriteRoute

object FavoriteDestination : MpNavigationDestination {
    override val route = "favorite_route"
    override val destination = "favorite_destination"
}

fun NavGraphBuilder.favoriteGraph(
    navigateToPokemonDetail: (Int) -> Unit,
    nestedGraphs: NavGraphBuilder.() -> Unit
) {
    navigation(
        route = FavoriteDestination.route,
        startDestination = FavoriteDestination.destination
    ) {
        composable(route = FavoriteDestination.destination) {
            FavoriteRoute(
                navigateToPokemonDetail = navigateToPokemonDetail
            )
        }
        nestedGraphs()
    }
}