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

    suspend fun getPokemons(): List<Pokemon> {
        return pokemonRepository.getPokemonsStream()
    }
}