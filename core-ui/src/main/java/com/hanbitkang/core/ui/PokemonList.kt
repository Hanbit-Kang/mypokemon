package com.hanbitkang.core.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hanbitkang.core.data.model.Pokemon

@Composable
fun PokemonList(
    pokemons: List<Pokemon>
) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(pokemons) {
            PokemonCard(pokemon = it)
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
            AsyncImage(
                model = pokemon.getImageUrl(),
                contentDescription = null
            )
            Text(pokemon.name)
        }
    }
}