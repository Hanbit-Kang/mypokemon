package com.pe.feature.pokemondetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PokemonDetailRoute(
    modifier: Modifier = Modifier
    // TODO: ViewModel
) {
    // TODO: Get ui state
    PokemonDetailScreen()
}

@Composable
internal fun PokemonDetailScreen() {
    Text("PokemonDetail")
}