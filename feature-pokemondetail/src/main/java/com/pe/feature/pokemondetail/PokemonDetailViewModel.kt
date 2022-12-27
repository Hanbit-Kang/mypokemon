package com.pe.feature.pokemondetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.hanbitkang.core.data.repository.PokemonRepository
import com.pe.feature.pokemondetail.navigation.PokemonDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    val pokemonId: Int = savedStateHandle[PokemonDetailDestination.pokemonIdArg] ?: 0
}