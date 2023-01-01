package com.hanbitkang.core.model

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