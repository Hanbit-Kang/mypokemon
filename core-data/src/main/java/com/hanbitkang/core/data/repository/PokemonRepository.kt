package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.Syncable
import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.model.Pokemon
import com.hanbitkang.core.model.PokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonRepository : Syncable {
    fun getPokemonsStream(): Flow<List<Pokemon>>
    fun getFavoritePokemonsStream(): Flow<List<Pokemon>>
    fun getPokemon(id: Int): Flow<PokemonDetail>
    suspend fun updatePokemon(pokemonEntity: PokemonEntity)
    suspend fun syncWithPagination(page: Int)
}