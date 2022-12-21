package com.hanbitkang.core.data.model

import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.network.model.NetworkPokemon

data class Pokemon(
    val name: String,
    val url: String
) {
    fun toPokemonEntity() = PokemonEntity(
        name = name,
        url = url
    )

    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }
}

fun NetworkPokemon.toPokemon() = Pokemon(
    name = name,
    url = url
)

fun PokemonEntity.toPokemon() = Pokemon(
    name = name,
    url = url
)