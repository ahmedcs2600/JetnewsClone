package com.example.jetnewsclone.ui.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.R
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun DetailScreen(
    uiState: DetailUiState,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = { DetailScreenTopBar(
            title = uiState.toolbarTitle,
            image = uiState.toolbarImage,
            onBack = onBack
        ) },
        bottomBar = { DetailScreenBottomBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            content = {
                item {
                    PostHeaderItem(
                        uiState.pageImage,
                        uiState.pageTitle,
                        uiState.pageSubTitle,
                        uiState.userName,
                        uiState.date,
                        uiState.readTime
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(uiState.paragraph) {
                    Text(
                        text = it,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        )
    }
}

@Composable
private fun PostHeaderItem(
    @DrawableRes image: Int,
    title: String,
    subTitle: String,
    userName: String,
    date: String,
    readTime: String
) {
    HeaderImage(image)
    Spacer(modifier = Modifier.height(8.dp))
    PostTitle(title)
    Spacer(modifier = Modifier.height(8.dp))
    PostSubTitle(subTitle)
    Spacer(modifier = Modifier.height(8.dp))
    UserAndDateReadTimeView(userName, date, readTime)
}

@Composable
private fun PostSubTitle(text: String) {
    Text(text = text)
}

@Composable
private fun UserAndDateReadTimeView(userName: String, date: String, readTime: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
       Image(
           imageVector = Icons.Filled.AccountCircle,
           contentDescription = null,
           modifier = Modifier
               .width(50.dp)
               .height(50.dp)
       )
       Spacer(modifier = Modifier.width(10.dp))
       Column {
            Text(text = userName)
            Text(text = "$date - $readTime read")
       }
    }
}

@Composable
private fun HeaderImage(@DrawableRes image: Int) {
    Image(
        painter = painterResource(id = R.drawable.post_4),
        contentDescription = null,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun PostTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge
    )
}

@MultiPreviews
@Composable
fun DetailScreenPreview() {
    JetNewTheme {
        DetailScreen(
            uiState = DetailUiState(
                toolbarTitle = "Published in:\nAndroid Developers",
                toolbarImage = R.drawable.icon_article_background,
                pageImage = R.drawable.post_4,
                pageTitle = "Locale changes and the AndroidViewModel antipattern",
                pageSubTitle = "TL;DR: Expose resource IDs from ViewModels to avoid showing absolete data.",
                userName = "Jose Alcerreca",
                date = "April 02",
                readTime = "1 min read",
                paragraph = listOf(
                    "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                    "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                    "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                    "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                ),
            ),
            onBack = {}
        )
    }
}
