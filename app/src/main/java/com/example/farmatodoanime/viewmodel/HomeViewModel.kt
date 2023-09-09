package com.example.farmatodoanime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.domain.repositories.AnimeService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: AnimeService) : ViewModel() {
    private val _animeList = MutableLiveData<List<AnimeResponseData>?>()
    val animeList: MutableLiveData<List<AnimeResponseData>?> get() = _animeList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading



    init {
        _isLoading.value = true
        loadAnimeList()
    }

    private fun loadAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getPopularAnimes()
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    _animeList.postValue(body)
                    _isLoading.postValue(false)
                } else {
                    _isLoading.postValue(false)
                }
            } catch (e: Exception) {
                _isLoading.postValue(false)
            }
        }
    }
}
