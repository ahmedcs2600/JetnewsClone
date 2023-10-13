package com.example.jetnewsclone.ui.people

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.data.datasource.interests.people
import com.example.jetnewsclone.ui.common.InterestItem
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun PeopleScreen(
    modifier: Modifier = Modifier,
    uiState: PeopleUiState
) {
    val isLoading = uiState.isLoading
    if(isLoading) {
        LoadingContent(modifier = modifier.fillMaxSize())
    } else {
        PeopleContent(modifier = modifier.fillMaxSize(), people = uiState.data)
    }
}

@Composable
fun PeopleContent(modifier: Modifier, people: List<String>) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        content = {
            items(people.size) { index ->
                InterestItem(
                    title = people[index],
                    onSaveButtonClick = {},
                    isSaved = false
                )
            }
        })
}

@Composable
private fun LoadingContent(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@MultiPreviews
@Composable
fun PeopleScreenPreview() {
     JetNewTheme {
        Surface {
            PeopleScreen(uiState = PeopleUiState(data = people))
        }
    }
}