package com.hanbitkang.mypokemon.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.hanbitkang.core_designsystem.theme.MyPokemonTheme
import com.hanbitkang.mypokemon.navigation.MpNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MpApp() {
    MyPokemonTheme {
        Scaffold {
            MpNavHost(
                navController = rememberNavController()
            )
        }
    }
}