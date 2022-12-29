package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.Syncable
import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.model.PokemonDetail
import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.network.model.NetworkPokemonDetail
import kotlinx.coroutines.flow.Flow

interface PokemonRepository : Syncable {
    fun getPokemonsStream(): Flow<List<Pokemon>>
    fun getPokemon(id: Int): Flow<PokemonDetail>
    suspend fun updatePokemon(pokemonEntity: PokemonEntity)
    suspend fun syncWithPagination(page: Int)
}