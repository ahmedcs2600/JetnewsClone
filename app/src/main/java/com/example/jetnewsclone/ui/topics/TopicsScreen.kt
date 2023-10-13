package com.example.jetnewsclone.ui.topics

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.data.datasource.interests.topics
import com.example.jetnewsclone.ui.common.InterestItem
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun TopicsScreen(
    uiState: TopicsUiState,
    modifier: Modifier = Modifier,
    onSaveButtonClick: (String) -> Unit
) {
    val isLoading = uiState.isLoading
    if(isLoading) {
        LoadingContent(modifier = modifier.fillMaxSize())
    } else {
        TopicsContent(
            modifier = modifier.fillMaxSize(),
            topics = uiState.topics,
            savedTopics = uiState.savedTopics,
            onSaveButtonClick = onSaveButtonClick
        )
    }
}

@Composable
private fun TopicsContent(
    modifier: Modifier = Modifier,
    topics: Map<String, List<String>>,
    savedTopics: Set<String>,
    onSaveButtonClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        content = {
            for ((title, data) in topics) {
                item { Title(text = title) }
                items(data.size) { index ->
                    InterestItem(
                        title = data[index],
                        onSaveButtonClick = {
                            onSaveButtonClick(data[index])
                        },
                        isSaved = data[index] in savedTopics
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        })
}

@Composable
private fun LoadingContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
private fun Title(text: String) {
    Text(text = text)
}

@MultiPreviews
@Composable
fun TopicsScreenPreview() {
    JetNewTheme {
        Surface {
            TopicsScreen(
                uiState = TopicsUiState(topics = topics),
                onSaveButtonClick = { }
            )
        }
    }
}
