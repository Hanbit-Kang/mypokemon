package com.hanbitkang.feature.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hanbitkang.core.designsystem.component.MpToolbar
import com.hanbitkang.core.ui.PokemonList

@Composable
fun PokemonRoute(
    navigateToPokemonDetail: (Int) -> Unit,
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    val uiState: PokemonScreenUiState by viewModel.uiState.collectAsState()
    PokemonScreen(
        uiState = uiState,
        navigateToPokemonDetail = navigateToPokemonDetail,
        onScrollBottom = {
            viewModel.fetchNextPokemonPage()
        }
    )
}

@Composable
internal fun PokemonScreen(
    uiState: PokemonScreenUiState,
    navigateToPokemonDetail: (Int) -> Unit,
    onScrollBottom: () -> Unit
) {
    Column {
        MpToolbar(
            title = stringResource(id = R.string.pokemon_list),
            fontSize = 20,
            verticalPadding = 16
        )

        when (uiState) {
            is PokemonScreenUiState.Success -> {
                PokemonList(
                    modifier = Modifier.padding(10.dp),
                    pokemons = uiState.pokemons,
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
}