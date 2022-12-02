package com.hanbitkang.core.network

import com.hanbitkang.core.network.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MpNetworkDataSource {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse
}