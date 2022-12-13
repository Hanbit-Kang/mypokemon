package com.hanbitkang.core.network

import com.hanbitkang.core.network.model.NetworkPokemon
import com.hanbitkang.core.network.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MpNetworkDataSource {
    suspend fun getPokemonList(): List<NetworkPokemon>
}