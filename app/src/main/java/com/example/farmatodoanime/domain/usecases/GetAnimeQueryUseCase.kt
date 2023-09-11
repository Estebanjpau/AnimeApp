package com.example.farmatodoanime.domain.usecases

import com.example.farmatodoanime.domain.entities.AnimeResponse
import com.example.farmatodoanime.domain.repositories.AnimeQueryService
import retrofit2.Response
import javax.inject.Inject

class GetAnimeQueryUseCase @Inject constructor(private val repository: AnimeQueryService) {
    suspend fun executeSearchAnime(query: String): Response<AnimeResponse> {
        return repository.searchAnime(query = query)
    }
}