package com.hanbitkang.feature.pokemon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = hiltViewModel(),
) {

}

@Composable
internal fun PokemonScreen(

) {
    Text(text = "PokemonScreen")
}