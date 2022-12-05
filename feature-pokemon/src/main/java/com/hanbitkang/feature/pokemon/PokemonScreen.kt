package com.hanbitkang.feature.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonRoute(
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel = hiltViewModel(),
) {
    PokemonScreen(
        viewModel
    )
}

@Composable
internal fun PokemonScreen(
    viewModel: PokemonViewModel
) {
    Column {
        Text(text = "PokemonScreen")
        Button(
            onClick = {
                viewModel.testRetrofit()
            }
        ) {
            Text("Test")
        }
    }
}