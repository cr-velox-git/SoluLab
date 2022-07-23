package com.solulab.coin.di

import com.solulab.coin.data.remote.ApiService
import com.solulab.coin.data.remote.dto.ResponseDtoMapper
import com.solulab.coin.domain.repositories.Repository
import com.solulab.coin.data.repositories.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideResponseRepository(
        apiService: ApiService,
        responseDtoMapper: ResponseDtoMapper
    ): Repository {
        return RepositoryImpl(
            apiService = apiService,
            mapper = responseDtoMapper
        )
    }
}