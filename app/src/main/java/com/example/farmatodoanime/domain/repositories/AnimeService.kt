package com.example.farmatodoanime.domain.repositories

import com.example.farmatodoanime.domain.entities.AnimeResponseData
import retrofit2.Response
import retrofit2.http.GET

interface AnimeService {
    @GET
    suspend fun getPopularAnimes(): Response<List<AnimeResponseData>?>
}