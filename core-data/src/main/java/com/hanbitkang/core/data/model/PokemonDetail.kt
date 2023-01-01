package com.hanbitkang.core.data.model

import com.hanbitkang.core.model.PokemonDetail
import com.hanbitkang.core.network.model.NetworkPokemonDetail
import com.hanbitkang.core.network.model.TypeResponse

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