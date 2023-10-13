package com.example.jetnewsclone.ui.publications

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.data.datasource.interests.publications
import com.example.jetnewsclone.ui.common.InterestItem
import com.example.jetnewsclone.ui.theme.JetNewTheme

@Composable
fun PublicationsScreen(
    uiState: PublicationsUiState,
    modifier: Modifier = Modifier
) {
    val isLoading = uiState.isLoading
    if(isLoading) {
        LoadingContent(modifier = modifier.fillMaxSize())
    } else {
        PublicationsContent(
            modifier = modifier.fillMaxSize(),
            publications = uiState.publications
        )
    }
}

@Composable
private fun LoadingContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun PublicationsContent(modifier: Modifier, publications: List<String>) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        content = {
            items(publications) { publication ->
                InterestItem(
                    title = publication,
                    isSaved = false,
                    onSaveButtonClick = {}
                )
            }
        })
}

@Preview
@Composable
fun PublicationsScreenPreview() {
    JetNewTheme {
        Surface {
            PublicationsScreen(
                uiState = PublicationsUiState(
                    isLoading = false,
                    publications = publications
                )
            )
        }
    }
}
