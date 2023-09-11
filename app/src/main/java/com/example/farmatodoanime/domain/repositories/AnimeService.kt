package com.example.farmatodoanime.domain.repositories

import com.example.farmatodoanime.domain.entities.AnimeResponse
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import retrofit2.Response
import retrofit2.http.GET

interface AnimeService {
    @GET("top/anime?filter=bypopularity")
    suspend fun getPopularAnimes(): Response<AnimeResponse>

    @GET("top/anime?filter=airing")
    suspend fun getPopularAnimesOnAiring(): Response<AnimeResponse>
}