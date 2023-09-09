package com.example.farmatodoanime.data.repositories

import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.domain.repositories.AnimeService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AnimeServiceImpl @Inject constructor(): AnimeService {

    private val animeService: AnimeService = getRetrofit().create(AnimeService::class.java)

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/top/anime?filter=bypopularity")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override suspend fun getPopularAnimes(): Response<List<AnimeResponseData>?> {
        try {
            val response = animeService.getPopularAnimes()

            // Verificar si la respuesta fue exitosa
            if (response.isSuccessful) {
                val animeResponse = response.body()
                if (animeResponse != null) {
                    println(animeResponse)
                    println(animeResponse)
                } else {
                    // La respuesta está vacía o nula
                }
            } else {
                // La respuesta no fue exitosa, puedes manejar el error aquí
            }
            return response // Puedes devolver la respuesta completa si es necesario
        } catch (e: Exception) {
            // Manejar excepciones, por ejemplo, problemas de red
            return Response.error(null, null)
        }
    }
}
