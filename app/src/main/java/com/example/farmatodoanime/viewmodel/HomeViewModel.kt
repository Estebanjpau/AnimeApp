package com.example.farmatodoanime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.domain.usecases.GetPopularAnimesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPopularAnimesUseCase: GetPopularAnimesUseCase) : ViewModel() {
    private val _animeList = MutableLiveData<List<AnimeResponseData>?>()
    val animeList: MutableLiveData<List<AnimeResponseData>?> get() = _animeList
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _animeListOnAiring = MutableLiveData<List<AnimeResponseData>?>()
    val animeListOnAiring: MutableLiveData<List<AnimeResponseData>?> get() = _animeListOnAiring
    private val _isLoading2 = MutableLiveData<Boolean>()
    val isLoading2: LiveData<Boolean> get() = _isLoading2

    fun loadAnimeList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getPopularAnimesUseCase.executeCallTopAnime()
                if (response.isSuccessful) {
                    val animeResponse = response.body()
                    val animeData = animeResponse?.data
                    _animeList.postValue(animeData)
                }
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _isLoading.postValue(false)
            }
        }
    }

    fun loadAnimeListOnAiring(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getPopularAnimesUseCase.executeCallTopAnimeOnAiring()
                if (response.isSuccessful) {
                    val animeResponse = response.body()
                    val animeData = animeResponse?.data
                    _animeListOnAiring.postValue(animeData)
                }
                _isLoading2.postValue(false)
            } catch (e: Exception) {
                _isLoading2.postValue(false)
            }
        }
    }
}
