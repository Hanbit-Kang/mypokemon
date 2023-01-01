package com.hanbitkang.core.model

/**
 * @param url example: https://pokeapi.co/api/v2/pokemon/1/
 */
data class Pokemon(
    val name: String,
    val url: String,
    val isFavorite: Boolean = false
) {

    fun getPokemonId(): Int {
        return url.split("/".toRegex()).dropLast(1).last().toInt()
    }

    fun getImageUrl(): String {
        val id = getPokemonId()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }
}