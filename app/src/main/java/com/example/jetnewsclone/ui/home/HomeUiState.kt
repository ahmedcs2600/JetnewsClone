package com.example.jetnewsclone.ui.home

import com.example.jetnewsclone.model.post.PostsFeed

data class HomeUiState(
    val isLoading: Boolean = false,
    val feed: PostsFeed? = null,
    val favourites: Set<String> = setOf()
)