package com.hanbitkang.feature.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.ui.PokemonList

@Composable
fun PokemonRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    val pokemonScreenUiState: PokemonScreenUiState by viewModel.uiState.collectAsState()

    viewModel.updateDatabaseByNetwork()
    PokemonScreen(pokemonScreenUiState)
}

@Composable
internal fun PokemonScreen(
    pokemonScreenUiState: PokemonScreenUiState
) {
    when (pokemonScreenUiState) {
        is PokemonScreenUiState.Success -> {
            PokemonList(pokemonScreenUiState.pokemons)
        }
        is PokemonScreenUiState.Loading -> {
            // TODO
        }
        is PokemonScreenUiState.Error -> {
            // TODO
        }
    }
}