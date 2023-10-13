package com.example.jetnewsclone.ui.topics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TopicsRoute(viewModel: TopicsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    TopicsScreen(
        uiState = uiState,
        onSaveButtonClick = viewModel::saveTopic
    )
}
