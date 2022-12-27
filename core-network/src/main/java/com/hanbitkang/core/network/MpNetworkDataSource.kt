package com.hanbitkang.core.network

import com.hanbitkang.core.network.model.NetworkPokemon
import com.hanbitkang.core.network.model.NetworkPokemonDetail

/**
 * Interface representing network calls to pokeapi`
 */
interface MpNetworkDataSource {
    suspend fun getPokemonList(limit: Int, offset: Int): List<NetworkPokemon>
    suspend fun getPokemon(id: Int): NetworkPokemonDetail
}