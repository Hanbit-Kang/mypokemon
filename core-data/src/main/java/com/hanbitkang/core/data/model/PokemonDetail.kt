package com.hanbitkang.core.data.model

import com.hanbitkang.core.network.model.NetworkPokemonDetail
import com.hanbitkang.core.network.model.TypeResponse

data class PokemonDetail (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val types: List<TypeResponse>,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val exp: Int
)

fun NetworkPokemonDetail.toPokemonDetail() = PokemonDetail(
    id = id,
    name = name,
    height = height,
    weight = weight,
    experience = experience,
    types = types,
    hp = hp,
    attack = attack,
    defense = defense,
    speed = speed,
    exp = exp
)