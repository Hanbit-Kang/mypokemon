package com.hanbitkang.feature.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    // TODO: StateFlow<PokemonUiState>
    val pokemons: StateFlow<List<Pokemon>> = pokemonRepository.getPokemonsStream()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = listOf()
        )
}