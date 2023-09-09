package com.example.farmatodoanime.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.farmatodoanime.R
import com.example.farmatodoanime.databinding.FragmentHomeBinding
import com.example.farmatodoanime.ui.adapters.AnimeAdapter
import com.example.farmatodoanime.viewmodel.HomeViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.rvTop10
        adapter = AnimeAdapter(emptyList())

        viewModel.animeList.observe(viewLifecycleOwner) { animeList ->
            animeList?.let {
                adapter = AnimeAdapter(it)
                recyclerView.adapter = adapter
            }
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_home_to_fragment_search)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}