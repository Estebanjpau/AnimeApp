package com.example.farmatodoanime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.farmatodoanime.domain.entities.AnimeResponseData
import com.example.farmatodoanime.domain.usecases.GetAnimeQueryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val getAnimeQueryUseCase: GetAnimeQueryUseCase) : ViewModel() {
    private val _searchAnimeList = MutableLiveData<List<AnimeResponseData>?>()
    val searchAnimeList: MutableLiveData<List<AnimeResponseData>?> get() = _searchAnimeList
    private val _isLoading3 = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading3

    fun searchAnime(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = getAnimeQueryUseCase.executeSearchAnime(query)
                if (response.isSuccessful) {
                    val animeResponse = response.body()
                    val animeData = animeResponse?.data
                    _searchAnimeList.postValue(animeData)
                }
                _isLoading3.postValue(false)
            } catch (e: Exception) {
                _isLoading3.postValue(false)
            }
        }
    }
}