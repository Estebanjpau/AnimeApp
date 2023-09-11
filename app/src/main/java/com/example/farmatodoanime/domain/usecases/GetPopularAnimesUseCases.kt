package com.example.farmatodoanime.domain.usecases

import com.example.farmatodoanime.domain.entities.AnimeResponse
import com.example.farmatodoanime.domain.repositories.AnimeService
import retrofit2.Response
import javax.inject.Inject

class GetPopularAnimesUseCase @Inject constructor(private val repository: AnimeService) {
      suspend fun executeCallTopAnime(): Response<AnimeResponse> {
        return repository.getPopularAnimes()
    }

    suspend fun executeCallTopAnimeOnAiring(): Response<AnimeResponse> {
        return repository.getPopularAnimesOnAiring()
    }
}