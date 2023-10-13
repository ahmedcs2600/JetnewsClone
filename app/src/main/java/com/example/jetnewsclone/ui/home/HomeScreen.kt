package com.example.jetnewsclone.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.data.datasource.post.posts
import com.example.jetnewsclone.model.post.Post
import com.example.jetnewsclone.model.post.PostsFeed
import com.example.jetnewsclone.ui.common.AppTopBar
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    openDrawer: () -> Unit,
    openDetails: () -> Unit,
    toggleBookmark: (String) -> Unit
) {
    Scaffold(
        topBar = { AppTopBar(openDrawer = openDrawer) }
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            uiState = uiState,
            openDetails = openDetails,
            toggleBookmark = toggleBookmark
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    uiState: HomeUiState,
    openDetails: () -> Unit,
    toggleBookmark: (String) -> Unit
) {
    if (uiState.isLoading) HomeLoading(modifier = modifier)
    else if(uiState.feed == null) EmptyFeed(modifier = modifier)
    else HomeContentList(
        feed = uiState.feed,
        favourites = uiState.favourites,
        modifier = modifier,
        openDetails = openDetails,
        toggleBookmark = toggleBookmark
    )
}

@Composable
private fun EmptyFeed(modifier: Modifier = Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center) {
        Text(text = "No Posts Found")
    }
}

@Composable
private fun HomeLoading(modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun HomeContentList(
    feed: PostsFeed,
    favourites: Set<String>,
    modifier: Modifier = Modifier,
    openDetails: () -> Unit,
    toggleBookmark: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        content = {
            item {
                Header(post = feed.highlightedPost, openDetails = openDetails)
            }
            items(feed.recommendedPosts.size) { index ->
                PostCard(
                    post =  feed.recommendedPosts[index],
                    isBookmarked = feed.recommendedPosts[index].id in favourites,
                    toggleBookmark = toggleBookmark
                )
            }
            item { PopularPosts(posts = feed.popularPosts) }
            items(feed.recentPosts.size) { index ->
                PostCard(
                    post = feed.recentPosts[index],
                    isBookmarked = feed.recentPosts[index].id in favourites,
                    toggleBookmark = toggleBookmark
                )
            }
        },
        contentPadding = PaddingValues(16.dp)
    )
}

@Composable
fun Header(
    post: Post,
    openDetails: () -> Unit
) {
    Column {
        Text(text = post.title)
        Spacer(modifier = Modifier.height(8.dp))
        PostCardTop(modifier = Modifier.clickable { openDetails() })
    }
}

@Composable
private fun PopularPosts(
    posts: List<Post>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = "Popular on Jetnews", modifier = Modifier.padding(8.dp))
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(posts.size) { index ->
                    PopularPostCard(posts[index])
                }
            })
    }
}

@MultiPreviews
@Composable
fun HomeScreenPreview() {
    JetNewTheme {
        Surface {
            HomeScreen(
                HomeUiState(
                    isLoading = false,
                    feed = posts
                ),
                openDrawer = {},
                openDetails = {},
                toggleBookmark = {}
            )
        }
    }
}
