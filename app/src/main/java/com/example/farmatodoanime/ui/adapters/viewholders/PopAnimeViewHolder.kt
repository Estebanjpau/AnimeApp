package com.example.farmatodoanime.ui.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.farmatodoanime.databinding.RvItemHomeBinding
import com.example.farmatodoanime.domain.entities.AnimeResponseData

class PopAnimeViewHolder(private val binding: RvItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(animeResponseData: AnimeResponseData){

        binding.tvTitle.text =animeResponseData.title
        //Glide.with(binding.ivPoster.context).load(animeResponseData.poster).into(binding.ivPoster)
        binding.tvRatingNumber.text = animeResponseData.rating
    }
}