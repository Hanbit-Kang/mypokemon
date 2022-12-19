package com.hanbitkang.core.database.dao

import androidx.room.*
import com.hanbitkang.core.database.model.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getPokemonEntityStream(): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonEntities(pokemonEntities: List<PokemonEntity>)

    @Delete
    suspend fun deletePokemonEntities(pokemonEntities: List<PokemonEntity>)
}