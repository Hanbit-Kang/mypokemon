package com.pe.feature.pokemondetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hanbitkang.core.common.Result
import com.hanbitkang.core.common.asResult
import com.hanbitkang.core.data.model.PokemonDetail
import com.hanbitkang.core.data.repository.PokemonRepository
import com.pe.feature.pokemondetail.navigation.PokemonDetailDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    pokemonRepository: PokemonRepository
) : ViewModel() {

    private val pokemonId: Int = savedStateHandle[PokemonDetailDestination.pokemonIdArg] ?: 0

    private val pokemonDetail: Flow<Result<PokemonDetail>> = pokemonRepository.getPokemon(pokemonId).asResult()

    val uiState: StateFlow<PokemonDetailScreenUiState> = pokemonDetail.mapLatest {
        when (it) {
            is Result.Success -> PokemonDetailScreenUiState.Success(it.data)
            is Result.Loading -> PokemonDetailScreenUiState.Loading
            is Result.Error -> PokemonDetailScreenUiState.Error
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = PokemonDetailScreenUiState.Loading
        )

    init {
        pokemonRepository.getPokemon(1)
    }
}

sealed interface PokemonDetailScreenUiState {
    data class Success(val pokemonDetail: PokemonDetail) : PokemonDetailScreenUiState
    object Loading : PokemonDetailScreenUiState
    object Error : PokemonDetailScreenUiState
}