package com.hanbitkang.mypokemon.navigation

import com.hanbitkang.core.designsystem.MpNavigationDestination

/**
 * Type for the top level destination of the application.
 */
data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val iconTextId: Int
) : MpNavigationDestination
