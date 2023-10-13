package com.example.jetnewsclone.ui.publications

data class PublicationsUiState(
    val isLoading: Boolean = false,
    val publications: List<String> = listOf()
)
