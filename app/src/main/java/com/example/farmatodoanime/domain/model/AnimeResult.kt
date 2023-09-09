package com.example.farmatodoanime.domain.model

import com.example.farmatodoanime.domain.entities.AnimeResponse
import java.io.IOException

sealed class AnimeResult {
    data class Success(val animeResponseList: List<AnimeResponse>) : AnimeResult()

    sealed class Error : AnimeResult() {
        data class Network(val exception: IOException) : Error()
        data class Http(val code: Int, val errorMessage: String?) : Error()
        data class Generic(val exception: Exception) : Error()
    }
}