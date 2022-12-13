package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import com.hanbitkang.core.network.MpNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OfflineFirstPokemonRepository @Inject constructor(
    private val network: MpNetworkDataSource
): PokemonRepository {
    override fun getPokemonsStream(): Flow<List<Pokemon>> {
        return flow {
            network.getPokemonList()
        }
    }
}