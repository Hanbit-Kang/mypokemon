package com.hanbitkang.core.data.di

import com.hanbitkang.core.data.repository.OfflineFirstPokemonRepository
import com.hanbitkang.core.data.repository.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsPokemonRepository(
        offlineFirstPokemonRepository: OfflineFirstPokemonRepository
    ): PokemonRepository
}