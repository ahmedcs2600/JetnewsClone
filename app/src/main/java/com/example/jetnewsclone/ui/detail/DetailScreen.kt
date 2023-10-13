package com.example.jetnewsclone.ui.detail

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
fun DetailScreen() {
    Scaffold(
        topBar = { DetailScreenTopBar() },
        bottomBar = { DetailScreenBottomBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            content = {
                item {
                    PostHeaderItem()
                }
                items(5) {
                    Text(text = "In a ViewModel, if you're exposing data coming from resources (strings, drawables, colors..)")
                }
            }
        )
    }
}

@Composable
private fun PostHeaderItem() {
    HeaderImage()
    PostTitle()
    PostSubTitle()
    UserAndDateReadTimeView()
}

@Composable
private fun PostSubTitle() {
    Text(text = "TL;DR: Expose resource IDs from ViewModels to avoid showing absolete data.")
}

@Composable
private fun UserAndDateReadTimeView() {
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
            Text(text = "Jose Alcerreca")
            Text(text = "April 02 - 1 min read")
       }
    }
}

@Composable
private fun HeaderImage() {
    Image(
        painter = painterResource(id = R.drawable.post_4),
        contentDescription = null,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun PostTitle() {
    Text(text = "Locale changes and the AndroidViewModel antipattern")
}

@MultiPreviews
@Composable
fun DetailScreenPreview() {
    JetNewTheme {
        DetailScreen()
    }
}
