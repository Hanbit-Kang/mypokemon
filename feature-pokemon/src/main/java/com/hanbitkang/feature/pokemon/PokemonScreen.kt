package com.hanbitkang.feature.pokemon

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hanbitkang.core.ui.PokemonList

@Composable
fun PokemonRoute(
    modifier: Modifier = Modifier,
    navigateToPokemonDetail: (Int) -> Unit,
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    val pokemonScreenUiState: PokemonScreenUiState by viewModel.uiState.collectAsState()
    PokemonScreen(
        pokemonScreenUiState = pokemonScreenUiState,
        navigateToPokemonDetail = navigateToPokemonDetail,
        onScrollBottom = {
            viewModel.fetchNextPokemonPage()
        }
    )
}

@Composable
internal fun PokemonScreen(
    pokemonScreenUiState: PokemonScreenUiState,
    navigateToPokemonDetail: (Int) -> Unit,
    onScrollBottom: () -> Unit
) {
    when (pokemonScreenUiState) {
        is PokemonScreenUiState.Success -> {
            PokemonList(
                modifier = Modifier.padding(10.dp),
                pokemons = pokemonScreenUiState.pokemons,
                navigateToPokemonDetail = navigateToPokemonDetail,
                onScrollBottom = onScrollBottom
            )
        }
        is PokemonScreenUiState.Loading -> {
            // TODO
        }
        is PokemonScreenUiState.Error -> {
            // TODO
        }
    }
}