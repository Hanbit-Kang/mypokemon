package com.hanbitkang.core.database.di

import android.content.Context
import androidx.room.Room
import com.hanbitkang.core.database.MpDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesMpDatabase(
        @ApplicationContext context: Context
    ) : MpDatabase = Room.databaseBuilder(
        context,
        MpDatabase::class.java,
        "mp-database"
    ).build()
}