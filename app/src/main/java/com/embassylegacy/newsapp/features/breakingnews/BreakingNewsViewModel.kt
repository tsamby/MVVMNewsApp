package com.embassylegacy.newsapp.features.breakingnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.embassylegacy.newsapp.data.NewsArticle
import com.embassylegacy.newsapp.data.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakingNewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val refreshTriggerChannel = Channel<Unit>()
    private val refreshTrigger = refreshTriggerChannel.receiveAsFlow()

    val breakingNews = refreshTrigger.flatMapLatest {
        repository.getBreakingNews()
    }.stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun onManualRefresh (){
    viewModelScope.launch {
        refreshTriggerChannel.send(Unit)
    }
}
}