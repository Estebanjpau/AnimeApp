package com.example.farmatodoanime.domain.repositories

import com.example.farmatodoanime.domain.entities.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeQueryService {
    @GET("anime")
    suspend fun searchAnime(@Query("q") query: String): Response<AnimeResponse>
}
