package com.example.farmatodoanime.domain.entities

import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val data: MutableList<AnimeResponseData>
)

data class AnimeResponseData(
    @SerializedName("type")
    val type: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("images")
    val poster: Images,
    @SerializedName("score")
    val rating: String,
    @SerializedName("synopsis")
    val description: String,
    @SerializedName("year")
    val releaseDate: String,
)

data class Images(
    @SerializedName("jpg")
    val jpg: ImageJpg,
)

data class ImageJpg(
    @SerializedName("large_image_url")
    val url: String,
)
