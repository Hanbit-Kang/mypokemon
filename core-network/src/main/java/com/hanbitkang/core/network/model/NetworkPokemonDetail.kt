package com.hanbitkang.core.network.model

import com.google.gson.annotations.SerializedName

data class NetworkPokemonDetail (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeResponse>,
    val stats: List<Stat>
)

data class TypeResponse(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String,
    val url: String
)

data class Stat(
    @SerializedName("base_stat") val baseStat: Int,
    val effort: Int,
    val stat: StatNameUrl
)

data class StatNameUrl(
    val name: String,
    val url: String
)