package com.hanbitkang.feature.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hanbitkang.core.data.model.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
fun PokemonRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    PokemonScreen(viewModel)
}

@Composable
internal fun PokemonScreen(
    viewModel: PokemonViewModel
) {
    val pokemons: List<Pokemon> by viewModel.pokemons.collectAsState()

    Column {
        Button(
            onClick = {
                CoroutineScope(Dispatchers.IO).launch {
                    // TODO: Update local database temporarily
                    // TODO: Get pokemons by network to update local database
                }
            }
        ) {
            Text("Test")
        }

        LazyColumn {
            items(pokemons) {
                PokemonCard(pokemon = it)
            }
        }
    }
}

@Composable
private fun PokemonCard(pokemon: Pokemon) {
    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(pokemon.name)
        }
    }
}