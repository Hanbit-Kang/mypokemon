package com.hanbitkang.feature.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.repository.PokemonRepository
import com.hanbitkang.core.common.Result
import com.hanbitkang.core.common.asResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {
    private val pokemons: Flow<Result<List<Pokemon>>> = pokemonRepository.getPokemonsStream().asResult()

    val uiState: StateFlow<PokemonScreenUiState> = pokemons.mapLatest {
        when (it) {
            is Result.Success -> PokemonScreenUiState.Success(it.data)
            is Result.Loading -> PokemonScreenUiState.Loading
            else -> PokemonScreenUiState.Error
        }
    }   .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PokemonScreenUiState.Loading
        )

    fun updateDatabaseByNetwork() {
        viewModelScope.launch {
            pokemonRepository.sync()
        }
    }
}

sealed interface PokemonScreenUiState {
    data class Success(val pokemons: List<Pokemon>) : PokemonScreenUiState
    object Loading : PokemonScreenUiState
    object Error : PokemonScreenUiState
}