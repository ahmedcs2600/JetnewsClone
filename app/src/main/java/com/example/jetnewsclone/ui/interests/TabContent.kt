package com.example.jetnewsclone.ui.interests

import androidx.compose.runtime.Composable

data class TabContent(
    val tab: TabItem,
    val content: @Composable () -> Unit
)