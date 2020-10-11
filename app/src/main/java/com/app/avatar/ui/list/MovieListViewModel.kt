package com.app.avatar.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.avatar.Event
import com.app.avatar.data.model.MovieItem
import com.app.avatar.data.source.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(private val repository: Repository) : ViewModel() {
    private val _navigateToDetailEvent = MutableLiveData<Event<String>>()
    val navigateToDetailEvent: LiveData<Event<String>> = _navigateToDetailEvent

    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    val movieList: LiveData<List<MovieItem>> = repository.observeList()

    init {
        viewModelScope.launch {
            repository.refreshMovieItems()
        }
    }

    fun navigateToDetail(id: String) {
        _navigateToDetailEvent.value = Event(id)
    }
}

class MovieListViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieListViewModel(repository) as T
    }
}