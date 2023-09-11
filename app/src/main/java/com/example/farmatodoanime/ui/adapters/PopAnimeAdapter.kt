package com.example.farmatodoanime.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.farmatodoanime.databinding.RvItemHomeBinding
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.ui.adapters.viewholders.PopAnimeViewHolder

class AnimeAdapter(private val context: Context, private var animeList: List<AnimeResponseData>) :
    RecyclerView.Adapter<PopAnimeViewHolder>() {

    init {
        animeList = animeList.map { anime ->
            val type = anime.type ?: ""
            val title = anime.title ?: ""
            val rating = anime.rating ?: ""
            val description = anime.description ?: ""
            val releaseDate = anime.releaseDate ?: ""

            anime.copy(
                type = type,
                title = title,
                rating = rating,
                description = description,
                releaseDate = releaseDate
            )
        }.filter { anime ->
            anime.type.isNotEmpty() &&
                    anime.title.isNotEmpty() &&
                    anime.rating.isNotEmpty() &&
                    anime.description.isNotEmpty() &&
                    anime.releaseDate.isNotEmpty()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopAnimeViewHolder {
        val binding = RvItemHomeBinding.inflate(LayoutInflater.from(context), parent, false)
        return PopAnimeViewHolder(context, binding)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: PopAnimeViewHolder, position: Int) {
        val anime = animeList[position]
        holder.bind(anime)
    }
}


