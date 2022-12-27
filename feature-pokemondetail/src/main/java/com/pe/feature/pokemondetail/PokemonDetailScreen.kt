package com.pe.feature.pokemondetail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonDetailRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val pokemonDetailScreenUiState: PokemonDetailScreenUiState by viewModel.uiState.collectAsState()
    PokemonDetailScreen(pokemonDetailScreenUiState)
}

@Composable
internal fun PokemonDetailScreen(
    pokemonDetailScreenUiState: PokemonDetailScreenUiState
) {
    when (pokemonDetailScreenUiState) {
        is PokemonDetailScreenUiState.Success -> {
            Text(text = pokemonDetailScreenUiState.pokemon.toString())
        }
        is PokemonDetailScreenUiState.Loading -> {
            // TODO
            Text(text = "Loading")
        }
        is PokemonDetailScreenUiState.Error -> {
            // TODO
            Text(text = pokemonDetailScreenUiState.exception.toString())
        }
    }
}