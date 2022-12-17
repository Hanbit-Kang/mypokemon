package com.hanbitkang.core.data.model

import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.network.model.NetworkPokemon

data class Pokemon(
    val name: String
)

fun NetworkPokemon.toPokemon() = Pokemon(
    name = name
)

fun PokemonEntity.toPokemon() = Pokemon(
    name = name
)