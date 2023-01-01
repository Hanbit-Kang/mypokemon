package com.hanbitkang.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.common.Result
import com.hanbitkang.core.common.asResult
import com.hanbitkang.core.data.model.toPokemonEntity
import com.hanbitkang.core.model.Pokemon
import com.hanbitkang.core.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val favoritePokemons: Flow<Result<List<Pokemon>>> = pokemonRepository.getFavoritePokemonsStream().asResult()

    val uiState: StateFlow<FavoriteScreenUiState> = favoritePokemons.mapLatest {
        when (it) {
            is Result.Success -> {
                if (it.data.isNotEmpty()) FavoriteScreenUiState.Success(it.data)
                else FavoriteScreenUiState.Empty
            }
            is Result.Loading -> FavoriteScreenUiState.Loading
            is Result.Error -> FavoriteScreenUiState.Error
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = FavoriteScreenUiState.Loading
        )

    fun switchIsFavorite(pokemon: Pokemon) {
        viewModelScope.launch {
            pokemonRepository.updatePokemon(
                pokemon.toPokemonEntity().apply { isFavorite = !pokemon.isFavorite }
            )
        }
    }
}

sealed interface FavoriteScreenUiState {
    data class Success(val favoritePokemons: List<Pokemon>) : FavoriteScreenUiState
    object Empty : FavoriteScreenUiState
    object Loading : FavoriteScreenUiState
    object Error : FavoriteScreenUiState
}