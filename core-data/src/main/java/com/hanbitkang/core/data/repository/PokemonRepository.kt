package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.Syncable
import com.hanbitkang.core.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository : Syncable {
    fun getPokemonsStream(): Flow<List<Pokemon>>
    suspend fun syncWithPagination(page: Int)
}