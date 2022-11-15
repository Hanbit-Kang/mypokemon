package com.hanbitkang.feature_favorite.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hanbitkang.core_navigation.MpNavigationDestination
import com.hanbitkang.feature_favorite.FavoriteScreen

object FavoriteDestination : MpNavigationDestination {
    override val route = "favorite_route"
    override val destination = "favorite_destination"
}

fun NavGraphBuilder.favoriteGraph() {
    composable(route = FavoriteDestination.route) {
        FavoriteScreen()
    }
}