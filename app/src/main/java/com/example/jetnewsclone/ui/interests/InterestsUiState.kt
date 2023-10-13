package com.example.jetnewsclone.ui.interests

data class InterestsUiState(
    val selectedTab: TabItem = TabItem.TOPICS,
    val tabs: List<TabItem> = listOf(
        TabItem.TOPICS,
        TabItem.PEOPLE,
        TabItem.PUBLICATIONS
    )
)
