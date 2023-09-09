package com.example.farmatodoanime.domain.entities

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val data: List<AnimeResponseData>
)

data class AnimeResponseData(
    @SerializedName("type")
    val type: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val poster: images,
    @SerializedName("score")
    val rating: String,
    @SerializedName("synopsis")
    val description: String,
    @SerializedName("year")
    val releaseDate: String,
)

data class images(
    @SerializedName("large_image_url")
    val poster: String,
)
