package com.hanbitkang.feature.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.designsystem.component.MpToolbar
import com.hanbitkang.core.ui.PokemonList

@Composable
fun FavoriteRoute(
    navigateToPokemonDetail: (Int) -> Unit,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val uiState: FavoriteScreenUiState by viewModel.uiState.collectAsState()
    FavoriteScreen(
        uiState = uiState,
        navigateToPokemonDetail = navigateToPokemonDetail,
        switchIsFavorite = viewModel::switchIsFavorite
    )
}

@Composable
internal fun FavoriteScreen(
    uiState: FavoriteScreenUiState,
    navigateToPokemonDetail: (Int) -> Unit,
    switchIsFavorite: (Pokemon) -> Unit,
) {
    Column {
        MpToolbar(
            title = stringResource(id = R.string.my_favorites),
            fontSize = 20
        )

        when (uiState) {
            is FavoriteScreenUiState.Success -> {
                PokemonList(
                    pokemons = uiState.favoritePokemons,
                    navigateToPokemonDetail = navigateToPokemonDetail,
                    switchIsFavorite = switchIsFavorite
                )
            }
            is FavoriteScreenUiState.Empty -> {
                // TODO
            }
            is FavoriteScreenUiState.Loading -> {
                // TODO
            }
            is FavoriteScreenUiState.Error -> {
                // TODO
            }
        }
    }
}