package com.hanbitkang.core.network.retrofit

import com.hanbitkang.core.network.MpNetworkDataSource
import com.hanbitkang.core.network.model.NetworkPokemon
import com.hanbitkang.core.network.model.NetworkPokemonDetail
import com.hanbitkang.core.network.model.PokemonResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Singleton

private interface RetrofitMpNetworkApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse

    @GET("pokemon/{id}")
    suspend fun getPokemon(
        @Path("id") id: Int
    ): NetworkPokemonDetail
}

private const val MP_BASE_URL = "https://pokeapi.co/api/v2/"

/**
 * [MpNetworkDataSource] implementation that fetches pokemon list over network.
 */
class RetrofitMpNetwork: MpNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl(MP_BASE_URL)
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitMpNetworkApi::class.java)

    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): List<NetworkPokemon> = networkApi.getPokemonList(limit, offset).results

    override suspend fun getPokemon(id: Int): NetworkPokemonDetail = networkApi.getPokemon(id)
}