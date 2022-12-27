package com.hanbitkang.core.network.model

import com.google.gson.annotations.SerializedName

data class NetworkPokemonDetail (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    @SerializedName("base_experience") val experience: Int,
    val types: List<TypeResponse>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val exp: Int
)

data class TypeResponse(
    val slot: Int,
    val type: Type
)

data class Type (
    val name: String,
    val url: String
)