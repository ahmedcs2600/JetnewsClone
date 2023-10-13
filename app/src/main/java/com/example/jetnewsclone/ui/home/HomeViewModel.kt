package com.example.jetnewsclone.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetnewsclone.domain.posts.GetFavouritesUsecase
import com.example.jetnewsclone.domain.posts.GetPostFeedUsecase
import com.example.jetnewsclone.domain.posts.ToggleFavouritesUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mGetPostFeedUsecase: GetPostFeedUsecase,
    private val mToggleFavouritesUsecase: ToggleFavouritesUsecase,
    private val mGetFavouritesUsecase: GetFavouritesUsecase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        _uiState.value
    )

    init {
        getPostFeed()
        getFavourites()
    }

    private fun getPostFeed() {
        mGetPostFeedUsecase()
            .onEach { post -> _uiState.update { it.copy(feed = post) } }
            .onStart { _uiState.update { it.copy(isLoading = true) } }
            .onCompletion { _uiState.update { it.copy(isLoading = false) } }
            .launchIn(viewModelScope)
    }

    private fun getFavourites() {
        mGetFavouritesUsecase().onEach { fav -> _uiState.update { it.copy(favourites = fav) } }
            .launchIn(viewModelScope)
    }

    fun toggleFavourites(postId: String) {
        viewModelScope.launch {
            mToggleFavouritesUsecase(postId)
        }
    }
}
