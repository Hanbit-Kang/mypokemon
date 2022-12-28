package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.model.PokemonDetail
import com.hanbitkang.core.data.model.toPokemon
import com.hanbitkang.core.data.model.toPokemonDetail
import com.hanbitkang.core.database.dao.PokemonDao
import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.network.MpNetworkDataSource
import com.hanbitkang.core.network.model.NetworkPokemon
import com.hanbitkang.core.network.model.NetworkPokemonDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 *
 */
class OfflineFirstPokemonRepository @Inject constructor(
    private val pokemonDao: PokemonDao,
    private val network: MpNetworkDataSource
): PokemonRepository {
    override fun getPokemonsStream(): Flow<List<Pokemon>> {
        return pokemonDao.getPokemonEntityStream().map { pokemonEntities ->
            pokemonEntities.map {
                it.toPokemon()
            }
        }
    }

    override fun getPokemon(id: Int): Flow<PokemonDetail> {
        return flow {
            val networkPokemonDetail = network.getPokemon(id)
            emit(networkPokemonDetail.toPokemonDetail())
        }
    }

    override suspend fun sync() {
        syncWithPagination(0)
    }

    override suspend fun syncWithPagination(page: Int) {
        val remotePokemons = network.getPokemonList(
            PAGING_SIZE, PAGING_SIZE * page
        )
            .map(NetworkPokemon::toPokemon)
            .map(Pokemon::toPokemonEntity)
        val localPokemons = pokemonDao.getPokemonEntityStream().first()

        val pokemonsToInsert = remotePokemons.minus(localPokemons.toSet())
        pokemonDao.insertPokemonEntities(pokemonsToInsert)
    }

    companion object {
        private const val PAGING_SIZE = 20
    }
}