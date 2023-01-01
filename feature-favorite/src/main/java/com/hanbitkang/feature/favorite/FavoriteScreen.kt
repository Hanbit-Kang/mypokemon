package com.hanbitkang.feature.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hanbitkang.core.designsystem.component.MpToolbar
import com.hanbitkang.core.model.Pokemon
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
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = com.hanbitkang.core.designsystem.R.drawable.ic_round_hide_source_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(id = R.string.empty_favorite_pokemon),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 18.sp
                    )
                }
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