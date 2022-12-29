package com.hanbitkang.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hanbitkang.core.database.dao.PokemonDao
import com.hanbitkang.core.database.model.PokemonEntity

@Database(
    entities = [
        PokemonEntity::class
    ],
    version = 2,
    exportSchema = true,
)
abstract class MpDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}