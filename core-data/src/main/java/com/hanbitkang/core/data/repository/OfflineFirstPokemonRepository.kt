package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.data.model.toPokemon
import com.hanbitkang.core.network.MpNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OfflineFirstPokemonRepository @Inject constructor(
    private val network: MpNetworkDataSource
): PokemonRepository {
    // TODO: Change to flow from DAO
    override suspend fun getPokemonsStream(): List<Pokemon> {
        return network.getPokemonList().map {
            it.toPokemon()
        }
    }
}