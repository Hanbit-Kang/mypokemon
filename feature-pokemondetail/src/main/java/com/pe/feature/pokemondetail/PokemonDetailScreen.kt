package com.pe.feature.pokemondetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonDetailRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    // TODO: Get ui state
    PokemonDetailScreen(viewModel.pokemonId)
}

@Composable
internal fun PokemonDetailScreen(pokemonId: Int) {
    Text(pokemonId.toString())
}