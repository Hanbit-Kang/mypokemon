package com.hanbitkang.core.database.di

import com.hanbitkang.core.database.MpDatabase
import com.hanbitkang.core.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun providesPokemonDao(
        database: MpDatabase
    ) : PokemonDao = database.pokemonDao()
}