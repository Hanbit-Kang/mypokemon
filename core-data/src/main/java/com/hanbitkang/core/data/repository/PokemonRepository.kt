package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonsStream(): Flow<List<Pokemon>>
}