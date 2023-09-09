package com.example.farmatodoanime.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmatodoanime.databinding.RvItemHomeBinding
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.ui.adapters.viewholders.PopAnimeViewHolder

class AnimeAdapter(private var animeList: List<AnimeResponseData>) :
    RecyclerView.Adapter<PopAnimeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopAnimeViewHolder {
        val binding = RvItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopAnimeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: PopAnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.bind(anime)
    }

    fun updateData(newAnimeList: List<AnimeResponseData>) {
        animeList = newAnimeList
        notifyDataSetChanged()
    }
}


