package com.example.jetnewsclone.ui.publications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnewsclone.domain.interests.GetPublicationsUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PublicationsViewModel @Inject constructor(
    private val mGetPublicationsUsecase: GetPublicationsUsecase
): ViewModel() {

    private val _uiState = MutableStateFlow(PublicationsUiState())
    val uiState: StateFlow<PublicationsUiState>
        get() = _uiState.asStateFlow()

    init {
        getPublications()
    }

    private fun getPublications() {
        mGetPublicationsUsecase()
            .onEach {publications -> _uiState.update { it.copy(publications = publications) } }
            .onStart { _uiState.update { it.copy(isLoading = true) } }
            .onCompletion { _uiState.update { it.copy(isLoading = false) } }
            .launchIn(viewModelScope)
    }
}
