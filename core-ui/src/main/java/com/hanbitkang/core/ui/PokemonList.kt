package com.hanbitkang.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.hanbitkang.core.data.model.Pokemon

@Composable
fun PokemonList(
    pokemons: List<Pokemon>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(pokemons) {
            PokemonCard(pokemon = it)
        }
    }
}

@Composable
private fun PokemonCard(pokemon: Pokemon) {
    Card {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            AsyncImage(
                model = pokemon.getImageUrl(),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                pokemon.name,
                textAlign = TextAlign.Center
            )
        }
    }
}