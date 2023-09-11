package com.example.farmatodoanime.di

import com.example.farmatodoanime.data.repositories.AnimeQueryServiceImpl
import com.example.farmatodoanime.data.repositories.AnimeServiceImpl
import com.example.farmatodoanime.domain.repositories.AnimeQueryService
import com.example.farmatodoanime.domain.repositories.AnimeService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideAnimeService(impl: AnimeServiceImpl): AnimeService
    @Binds
    abstract fun provideAnimeQueryServices(impl: AnimeQueryServiceImpl): AnimeQueryService
}