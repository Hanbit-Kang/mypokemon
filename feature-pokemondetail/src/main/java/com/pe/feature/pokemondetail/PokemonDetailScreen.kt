package com.pe.feature.pokemondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.hanbitkang.core.data.model.PokemonDetail

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
            PokemonDetailItem(pokemonDetail = pokemonDetailScreenUiState.pokemonDetail)
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

@Composable
private fun PokemonDetailItem(
    pokemonDetail: PokemonDetail
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 32.dp)
    ) {
        AsyncImage(
            model = pokemonDetail.getImageUrl(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )
        Text(
            pokemonDetail.name,
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        TypeList(types = pokemonDetail.types)

        Spacer(modifier = Modifier.height(32.dp))

        InfoItem("height", pokemonDetail.height.toString())
        InfoItem("weight", pokemonDetail.weight.toString())
    }
}

@Composable
fun TypeList(
    types: List<String>
) {
    Row(
        horizontalArrangement = Arrangement.Center
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
fun InfoItem(
    name: String,
    value: String
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Card(
            modifier = Modifier
                .width(100.dp)
        ) {
            Text(
                text = name,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
        
        Spacer(modifier = Modifier.width(8.dp))

        Box(modifier = Modifier.width(100.dp)) {
            Text(
                text = value,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }
    }
}