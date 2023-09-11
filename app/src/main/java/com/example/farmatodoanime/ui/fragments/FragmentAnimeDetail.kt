package com.example.farmatodoanime.ui.fragments

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.farmatodoanime.databinding.FragmentAnimeDetailBinding
import com.example.farmatodoanime.domain.entities.AnimeResponseData

class AnimeDetailDialog(
    context: Context,
    private val animeData: AnimeResponseData
) : Dialog(context) {

    private var _binding: FragmentAnimeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentAnimeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTitle.text = animeData.title
        binding.tvDescription.text = animeData.description
        Glide.with(binding.ivPoster.context).load(animeData.poster.jpg.url).into(binding.ivPoster)
        binding.rbRating.rating = animeData.rating.toFloat()
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}