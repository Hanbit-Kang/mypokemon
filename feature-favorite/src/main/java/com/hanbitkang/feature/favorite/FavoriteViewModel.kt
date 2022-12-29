package com.hanbitkang.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.common.Result
import com.hanbitkang.core.common.asResult
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private val favoritePokemons: Flow<Result<List<Pokemon>>> = pokemonRepository.getPokemonsStream().asResult()

    val uiState: StateFlow<FavoriteScreenUiState> = favoritePokemons.mapLatest {
        when (it) {
            is Result.Success -> FavoriteScreenUiState.Success(it.data)
            is Result.Loading -> FavoriteScreenUiState.Loading
            is Result.Error -> FavoriteScreenUiState.Error
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = FavoriteScreenUiState.Loading
        )

}

sealed interface FavoriteScreenUiState {
    data class Success(val favoritePokemons: List<Pokemon>) : FavoriteScreenUiState
    object Loading : FavoriteScreenUiState
    object Error : FavoriteScreenUiState
}