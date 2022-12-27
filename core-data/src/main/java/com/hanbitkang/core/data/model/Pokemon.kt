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

    fun getPokemonId(): String {
        return url.split("/".toRegex()).dropLast(1).last()
    }

    fun getImageUrl(): String {
        val id = getPokemonId()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
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