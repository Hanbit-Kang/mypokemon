package com.hanbitkang.core.database.dao

import androidx.room.*
import com.hanbitkang.core.database.model.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon ORDER BY pokemon.id")
    fun getPokemonEntityStream(): Flow<List<PokemonEntity>>

    @Query("SELECT * FROM pokemon WHERE pokemon.isFavorite == 1 ORDER BY pokemon.id")
    fun getFavoritePokemonEntityStream(): Flow<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPokemonEntities(pokemonEntities: List<PokemonEntity>)

    @Delete
    suspend fun deletePokemonEntities(pokemonEntities: List<PokemonEntity>)

    @Update
    suspend fun updatePokemonEntity(pokemonEntity: PokemonEntity)
}