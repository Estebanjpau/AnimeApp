package com.example.farmatodoanime.ui.adapters.viewholders

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.farmatodoanime.databinding.RvItemHomeBinding
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.ui.fragments.AnimeDetailDialog

class PopAnimeViewHolder(private val context: Context, private val binding: RvItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(animeResponseData: AnimeResponseData){

        val rating = animeResponseData.rating
        var filledStars = 0f
        val poster = animeResponseData.poster.jpg.url
        if (poster != "null"){

        }

        if (rating != "0"){
            filledStars = ((rating.toFloat())/2)
        }

        binding.tvTitle.text = animeResponseData.title
        Glide.with(binding.ivPoster.context).load(animeResponseData.poster.jpg.url).into(binding.ivPoster)
        binding.tvRatingNumber.text = rating
        binding.rbRating.rating = filledStars

        binding.ivPoster.setOnClickListener{
            val animeDetailDialog = AnimeDetailDialog(context, animeResponseData)
            animeDetailDialog.show()
        }
    }
}