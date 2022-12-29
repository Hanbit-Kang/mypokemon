package com.hanbitkang.core.data.model

import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.network.model.NetworkPokemon

/**
 * @param url example: https://pokeapi.co/api/v2/pokemon/1/
 */
data class Pokemon(
    val name: String,
    val url: String,
    val isFavorite: Boolean = false
) {

    fun toPokemonEntity() = PokemonEntity(
        id = getPokemonId(),
        name = name,
        url = url
    )

    fun getPokemonId(): Int {
        return url.split("/".toRegex()).dropLast(1).last().toInt()
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
    url = url,
    isFavorite = isFavorite
)