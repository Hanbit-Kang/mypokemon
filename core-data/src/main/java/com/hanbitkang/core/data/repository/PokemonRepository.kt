package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    // TODO: Change type to Flow<List<Pokemon>> + remove suspend keyword
    suspend fun getPokemonsStream(): List<Pokemon>
}