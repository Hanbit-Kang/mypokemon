package com.hanbitkang.core.data.model

import com.hanbitkang.core.database.model.PokemonEntity
import com.hanbitkang.core.model.Pokemon
import com.hanbitkang.core.network.model.NetworkPokemon

fun Pokemon.toPokemonEntity() = PokemonEntity(
    id = getPokemonId(),
    name = name,
    url = url
)

fun NetworkPokemon.toPokemon() = Pokemon(
    name = name,
    url = url
)

fun PokemonEntity.toPokemon() = Pokemon(
    name = name,
    url = url,
    isFavorite = isFavorite
)