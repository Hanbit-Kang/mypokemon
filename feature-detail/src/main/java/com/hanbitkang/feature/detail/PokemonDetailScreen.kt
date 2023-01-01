package com.hanbitkang.feature.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.hanbitkang.core.model.PokemonDetail
import com.hanbitkang.core.designsystem.component.MpToolbar

@Composable
fun PokemonDetailRoute(
    onClickBackButton: () -> Unit,
    viewModel: PokemonDetailViewModel = hiltViewModel()
) {
    val uiState: PokemonDetailScreenUiState by viewModel.uiState.collectAsState()
    PokemonDetailScreen(
        uiState = uiState,
        onClickBackButton = onClickBackButton
    )
}

@Composable
internal fun PokemonDetailScreen(
    uiState: PokemonDetailScreenUiState,
    onClickBackButton: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MpToolbar(
            onClickBackButton = onClickBackButton,
            title = "Pokemon Detail"
        )

        when (uiState) {
            is PokemonDetailScreenUiState.Success -> {
                PokemonDetailItem(pokemonDetail = uiState.pokemonDetail)
            }
            is PokemonDetailScreenUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            is PokemonDetailScreenUiState.Error -> {
                // TODO
            }
        }
    }
}

@Composable
private fun PokemonDetailItem(
    pokemonDetail: PokemonDetail
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = pokemonDetail.getImageUrl(),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
            )
            Text(
                pokemonDetail.name,
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(12.dp))

            TypeList(types = pokemonDetail.types)
            Spacer(modifier = Modifier.height(16.dp))

            HeightAndWeight(pokemonDetail)
            Spacer(modifier = Modifier.height(24.dp))

            StatList(pokemonDetail)
        }
    }
}


@Composable
fun TypeList(
    types: List<String>
) {
    Row(
        horizontalArrangement = Arrangement.Center,
    ) {
        types.forEach {
            Card(
                modifier = Modifier.padding(4.dp, 0.dp)
            ) {
                Text(
                    text = it,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(8.dp, 0.dp)
                )
            }
        }
    }
}


@Composable
fun HeightAndWeight(pokemonDetail: PokemonDetail) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        HeightWeightItem("HEIGHT", pokemonDetail.height)
        HeightWeightItem("WEIGHT", pokemonDetail.weight)
    }
}

@Composable
fun HeightWeightItem(
    name: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name
        )
        Text(
            text = value,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}


@Composable
fun StatList(pokemonDetail: PokemonDetail) {
    Text(
        text = "Stats",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(pokemonDetail.stats) {
            StatItem(name = it.first, value = it.second.toString())
        }
    }
}

@Composable
fun StatItem(
    name: String,
    value: String
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier.width(50.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        
        Spacer(modifier = Modifier.width(8.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = value,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}