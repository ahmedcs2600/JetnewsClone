package com.example.jetnewsclone.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    openDrawer: () -> Unit,
    openDetails: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
    ) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState,
        openDrawer = openDrawer,
        openDetails = openDetails,
        toggleBookmark = viewModel::toggleFavourites
    )
}
