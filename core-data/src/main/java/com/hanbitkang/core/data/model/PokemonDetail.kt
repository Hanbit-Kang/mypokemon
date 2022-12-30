package com.hanbitkang.core.data.model

import com.hanbitkang.core.network.model.NetworkPokemonDetail
import com.hanbitkang.core.network.model.TypeResponse

data class PokemonDetail (
    val id: Int,
    val name: String,
    val height: String,
    val weight: String,
    val types: List<String>,
    val stats: List<Pair<String, Int>>, // (name, base_stat)
) {
    fun getImageUrl() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
}

fun NetworkPokemonDetail.toPokemonDetail() = PokemonDetail(
    id = id,
    name = name,
    height = (height*0.1f).toString() + "M",
    weight = weight.toString() + "KG",
    types = types.map { it.type.name },
    stats = stats.map { Pair(convertStatName(it.stat.name), it.baseStat) }
)

private fun convertStatName(statName: String): String {
    return when (statName) {
        "hp" -> "HP"
        "attack" -> "ATK"
        "defense" -> "DEF"
        "special-attack" -> "SATK"
        "special-defense" -> "SDEF"
        "speed" -> "SPD"
        else -> "UNKNOWN"
    }
}