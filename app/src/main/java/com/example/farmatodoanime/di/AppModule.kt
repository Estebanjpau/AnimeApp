package com.example.farmatodoanime.di

import com.example.farmatodoanime.data.repositories.AnimeServiceImpl
import com.example.farmatodoanime.domain.repositories.AnimeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAnimeService(impl: AnimeServiceImpl): AnimeService {
        return impl
    }
}