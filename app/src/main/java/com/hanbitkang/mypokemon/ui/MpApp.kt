package com.hanbitkang.mypokemon.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.hanbitkang.core.designsystem.theme.MyPokemonTheme
import com.hanbitkang.mypokemon.navigation.MpNavHost
import com.hanbitkang.mypokemon.navigation.TopLevelDestination

@Composable
fun MpApp(
    appState: MpAppState = rememberMpAppState()
) {
    MyPokemonTheme {
        Scaffold (
            bottomBar = {
                MpBottomBar(
                    destinations = appState.topLevelDestinations,
                    onNavigateToDestination = appState::navigate,
                    currentDestination = appState.currentDestination
                )
            }
        ) { padding ->
            MpNavHost(
                navController = appState.navController,
                modifier = Modifier.padding(padding)
            )
        }
    }
}

@Composable
private fun MpBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
            BottomNavigationItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val iconId = if (selected) destination.selectedIconId else destination.unselectedIconId
                    Icon(painter = painterResource(id = iconId), contentDescription = null)
                },
                label = {
                    Text(stringResource(id = destination.iconTextId))
                }
            )
        }
    }
}