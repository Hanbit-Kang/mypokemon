package com.hanbitkang.mypokemon.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.hanbitkang.core.designsystem.component.MpBackground
import com.hanbitkang.core.designsystem.theme.MpTheme
import com.hanbitkang.mypokemon.navigation.MpNavHost
import com.hanbitkang.mypokemon.navigation.TopLevelDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MpApp(
    appState: MpAppState = rememberMpAppState()
) {
    MpTheme {
        MpBackground {
            Scaffold (
                bottomBar = {
                    MpBottomBar(
                        destinations = appState.topLevelDestinations,
                        onNavigateToDestination = appState::navigate,
                        currentDestination = appState.currentDestination
                    )
                }
            ) { paddingValues ->
                MpNavHost(
                    navController = appState.navController,
                    onNavigateToDestination = appState::navigate,
                    onClickBackButton = appState::onClickBackButton,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Composable
private fun MpBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    NavigationBar(
        containerColor = Color.White,
        contentColor = MaterialTheme.colorScheme.onSurfaceVariant
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationBarItem(
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