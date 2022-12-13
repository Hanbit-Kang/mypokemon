package com.hanbitkang.core.data.repository

import com.hanbitkang.core.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

class OfflineFirstPokemonRepository: PokemonRepository {
    override fun getPokemonsStream(): Flow<List<Pokemon>> {
        TODO("Not yet implemented")
    }
}