package com.example.jetnewsclone.ui.topics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnewsclone.domain.interests.GetSavedTopicsUsecase
import com.example.jetnewsclone.domain.interests.GetTopicsUsecase
import com.example.jetnewsclone.domain.interests.SaveTopicUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopicsViewModel @Inject constructor(
    private val mGetTopicsUsecase: GetTopicsUsecase,
    private val mGetSavedTopicsUsecase: GetSavedTopicsUsecase,
    private val mSaveTopicUsecase: SaveTopicUsecase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(TopicsUiState())
    val uiState: StateFlow<TopicsUiState>
        get() = _uiState.asStateFlow()

    init {
        getTopics()
        getSavedTopics()
    }

    private fun getSavedTopics() {
        mGetSavedTopicsUsecase()
            .onEach { topics -> _uiState.update { it.copy(savedTopics = topics) } }
            .launchIn(viewModelScope)
    }

    private fun getTopics() {
        mGetTopicsUsecase()
            .onEach { topics -> _uiState.update { it.copy(topics = topics) } }
            .onStart { _uiState.update { it.copy(isLoading = true) } }
            .onCompletion { _uiState.update { it.copy(isLoading = false) } }
            .launchIn(viewModelScope)
    }

    fun saveTopic(topic: String) {
        viewModelScope.launch {
            mSaveTopicUsecase(topic)
        }
    }
}
