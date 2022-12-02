package com.hanbitkang.core.network.model

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NetworkPokemon>
)
