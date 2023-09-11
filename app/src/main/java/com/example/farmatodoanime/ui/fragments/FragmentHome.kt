package com.example.farmatodoanime.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.farmatodoanime.databinding.FragmentHomeBinding
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.ui.adapters.AnimeAdapter
import com.example.farmatodoanime.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome: Fragment() {
    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var rvTopAnime: RecyclerView
    private lateinit var rvTopAnimeOnAiring: RecyclerView
    private lateinit var adapter: AnimeAdapter
    private lateinit var adapterTAOA: AnimeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTopAnime = binding.rvTop10
        rvTopAnime.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        rvTopAnimeOnAiring = binding.rvTopRecent
        rvTopAnimeOnAiring.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        viewModel.animeList.observe(viewLifecycleOwner) { animeList ->
            animeList?.let {
                adapter = AnimeAdapter(requireContext(),it)
                rvTopAnime.adapter = adapter
            }
        }

        viewModel.animeListOnAiring.observe(viewLifecycleOwner){ animeList ->
            animeList?.let {
                adapterTAOA = AnimeAdapter(requireContext(), it)
                rvTopAnimeOnAiring.adapter = adapterTAOA
            }
        }

        viewModel.loadAnimeList()
        viewModel.loadAnimeListOnAiring()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}