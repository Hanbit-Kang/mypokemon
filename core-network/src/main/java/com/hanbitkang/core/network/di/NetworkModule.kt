package com.hanbitkang.core.network.di

import com.hanbitkang.core.network.MpNetworkDataSource
import com.hanbitkang.core.network.retrofit.RetrofitMpNetwork
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsMpNetworkDataSource(
        retrofitMpNetwork: RetrofitMpNetwork
    ) : MpNetworkDataSource

    companion object {
        @Provides
        @Singleton
        fun providesRetrofitMpNetwork(): RetrofitMpNetwork =
            RetrofitMpNetwork()
    }
}