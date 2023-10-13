package com.example.jetnewsclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.R
import com.example.jetnewsclone.data.datasource.post.post1
import com.example.jetnewsclone.model.post.Post
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun PopularPostCard(
    post: Post,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
    ) {
        Column {
            PostImage()
            Column(modifier = Modifier.padding(8.dp)){
                Spacer(modifier = Modifier.height(12.dp))
                PostTitle(title = post.title)
                Spacer(modifier = Modifier.height(6.dp))
                PostAuthor(author = post.metadata.author.name)
                Spacer(modifier = Modifier.height(6.dp))
                PostDateAndReadTime(date = post.metadata.date, readTime = post.metadata.readTimeMinutes)
            }
        }
    }
}

@Composable
private fun PostImage() {
    Image(
        painter = painterResource(id = R.drawable.post_5),
        contentDescription = null,
        modifier = Modifier.height(100.dp),
    )
}

@Composable
private fun PostTitle(title: String) {
    Text(text = title, style = MaterialTheme.typography.titleMedium)
}

@Composable
private fun PostAuthor(author: String) {
    Text(text = author)
}

@Composable
fun PostDateAndReadTime(date: String, readTime: Int) {
    Text(text = "$date - $readTime min read")
}

@MultiPreviews
@Composable
fun PopularPostCardPreview() {
    JetNewTheme {
        Surface {
            PopularPostCard(post = post1)
        }
    }
}
