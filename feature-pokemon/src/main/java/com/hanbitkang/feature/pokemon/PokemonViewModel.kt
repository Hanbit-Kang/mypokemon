package com.hanbitkang.feature.pokemon

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.repository.PokemonRepository
import com.hanbitkang.core.common.Result
import com.hanbitkang.core.common.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
    // A pagination index for network
    private val _pokemonPage = MutableStateFlow(0)

    private val pokemons: Flow<Result<List<Pokemon>>> = pokemonRepository.getPokemonsStream().asResult()

    private var isNetworkProcessing = false

    val uiState: StateFlow<PokemonScreenUiState> = pokemons.mapLatest {
        when (it) {
            is Result.Success -> PokemonScreenUiState.Success(it.data)
            is Result.Loading -> PokemonScreenUiState.Loading
            is Result.Error -> PokemonScreenUiState.Error
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PokemonScreenUiState.Loading
        )

    init {
        viewModelScope.launch {
            _pokemonPage.collectLatest {
                isNetworkProcessing = true
                CoroutineScope(Dispatchers.IO).launch {
                    pokemonRepository.syncWithPagination(it)
                    isNetworkProcessing = false
                }
            }
        }
    }

    fun fetchNextPokemonPage() {
        if (uiState.value is PokemonScreenUiState.Success && !isNetworkProcessing) {
            _pokemonPage.value++
        }
    }

    fun switchIsFavorite(pokemon: Pokemon) {
        viewModelScope.launch {
            pokemonRepository.updatePokemon(
                pokemon.toPokemonEntity().apply { isFavorite = !pokemon.isFavorite }
            )
        }
    }
}

sealed interface PokemonScreenUiState {
    data class Success(val pokemons: List<Pokemon>) : PokemonScreenUiState
    object Loading : PokemonScreenUiState
    object Error : PokemonScreenUiState
}