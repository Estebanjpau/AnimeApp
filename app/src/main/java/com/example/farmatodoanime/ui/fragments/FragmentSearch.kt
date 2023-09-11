package com.example.farmatodoanime.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.farmatodoanime.R
import com.example.farmatodoanime.databinding.FragmentSearchBinding
import com.example.farmatodoanime.ui.adapters.AnimeAdapter
import com.example.farmatodoanime.viewmodel.HomeViewModel
import com.example.farmatodoanime.viewmodel.SearchViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentSearch : Fragment() {
    private val viewModel: SearchViewModel by viewModels()
    private var _binding: FragmentSearchBinding? = null

    private val binding get() = _binding!!

    private lateinit var rvSearchAnime: RecyclerView
    private lateinit var adapter: AnimeAdapter
    private var prefix = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSearchAnime = binding.rvSearchAnime
        rvSearchAnime.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)

        viewModel.searchAnimeList.observe(viewLifecycleOwner) { animeList ->
            animeList?.let {
                adapter = AnimeAdapter(requireContext(), it)
                rvSearchAnime.adapter = adapter
            }
        }

        binding.btnSearch.setOnClickListener {
            val query = binding.svSearch.query.toString()
            val filterQuery = prefix + query

            if (query.isNotEmpty()){
                viewModel.searchAnime(filterQuery)
            } else {
                Snackbar.make(view, "Debes ingresar una búsqueda válida", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.cbFinish.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbOnEmision.isChecked = false
                binding.cbOnRoad.isChecked = false
                prefix = "?status=complete&q="
            }
        }

        binding.cbOnEmision.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbFinish.isChecked = false
                binding.cbOnRoad.isChecked = false
                prefix = "?status=airing&q="
            }
        }

        binding.cbOnRoad.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.cbFinish.isChecked = false
                binding.cbOnEmision.isChecked = false
                prefix = "?status=upcoming&q="
            }
        }


        viewModel.searchAnimeList.observe(viewLifecycleOwner) { animeList ->
            val llNoResults = binding.llNoResults

            if (animeList != null) {
                if (animeList.isNotEmpty()) {
                    rvSearchAnime.visibility = View.VISIBLE
                    llNoResults.visibility = View.GONE
                    adapter = AnimeAdapter(requireContext(), animeList)
                    rvSearchAnime.adapter = adapter
                } else {
                    rvSearchAnime.visibility = View.GONE
                    llNoResults.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}