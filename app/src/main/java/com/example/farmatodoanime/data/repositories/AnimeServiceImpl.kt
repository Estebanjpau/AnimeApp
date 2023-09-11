package com.example.farmatodoanime.data.repositories

import android.util.Log
import com.example.farmatodoanime.data.network.RetrofitProvider
import com.example.farmatodoanime.domain.entities.AnimeResponse
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.domain.repositories.AnimeService
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class AnimeServiceImpl @Inject constructor(): AnimeService {
    private val animeService: AnimeService = RetrofitProvider.getRetrofit().create(AnimeService::class.java)
    override suspend fun getPopularAnimes(): Response<AnimeResponse> {
        try {
            val response = animeService.getPopularAnimes()

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

    override suspend fun getPopularAnimesOnAiring(): Response<AnimeResponse> {
        try {
            val response = animeService.getPopularAnimesOnAiring()

            if (response.isSuccessful){
                val animeResponse = response.body()
                if (animeResponse != null){
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
