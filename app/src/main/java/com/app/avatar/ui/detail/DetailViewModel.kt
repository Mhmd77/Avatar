package com.app.avatar.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.avatar.data.source.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: Repository) : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    fun refreshMovieInfo(id: String) {
        viewModelScope.launch {
            repository.refreshMovie(id)
        }
    }

    fun getObserver(id: String) = repository.observeMovie(id)
}

class DetailViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}