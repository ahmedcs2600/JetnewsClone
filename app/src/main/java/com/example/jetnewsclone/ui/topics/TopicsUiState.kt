package com.example.jetnewsclone.ui.topics

data class TopicsUiState(
    val topics: Map<String, List<String>> = mapOf(),
    val savedTopics: Set<String> = setOf(),
    val isLoading: Boolean = false
)
