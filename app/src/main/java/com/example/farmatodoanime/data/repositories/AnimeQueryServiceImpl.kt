package com.example.farmatodoanime.data.repositories

import android.util.Log
import com.example.farmatodoanime.data.network.RetrofitProvider
import com.example.farmatodoanime.domain.entities.AnimeResponse
import com.example.farmatodoanime.domain.repositories.AnimeQueryService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class AnimeQueryServiceImpl @Inject constructor(): AnimeQueryService {
    private val animeQueryService = RetrofitProvider.getRetrofit().create(AnimeQueryService::class.java)

    override suspend fun searchAnime(query: String): Response<AnimeResponse> {
        try {
            val response = animeQueryService.searchAnime(query)

            if (response.isSuccessful) {
                val animeResponse = response.body()
                if (animeResponse != null) {
                    Log.e("SuccessService", "Respuesta exitosa")
                } else {
                    Log.e("errorService","Respuesta Vacia")
                }
            } else {
                Log.e("errorService","Error de respuesta")
            }
            return response
        } catch (e: Exception) {
            return Response.error(500, ResponseBody.create(null, "Excepcion de red"))
        }
    }
}