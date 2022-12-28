package com.hanbitkang.core.data.model

import com.hanbitkang.core.network.model.NetworkPokemonDetail
import com.hanbitkang.core.network.model.TypeResponse

data class PokemonDetail (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<String>,
) {
    fun getImageUrl() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
}

fun NetworkPokemonDetail.toPokemonDetail() = PokemonDetail(
    id = id,
    name = name,
    height = height,
    weight = weight,
    types = types.map { it.type.name }
)