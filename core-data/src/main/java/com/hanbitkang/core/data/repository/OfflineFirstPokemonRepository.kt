package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.model.toPokemon
import com.hanbitkang.core.database.dao.PokemonDao
import com.hanbitkang.core.network.MpNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstPokemonRepository @Inject constructor(
    private val pokemonDao: PokemonDao
): PokemonRepository {
    override fun getPokemonsStream(): Flow<List<Pokemon>> {
        return pokemonDao.getPokemonEntityStream().map { pokemonEntities ->
            pokemonEntities.map {
                it.toPokemon()
            }
        }
    }
}