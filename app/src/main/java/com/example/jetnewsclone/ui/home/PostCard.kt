package com.example.jetnewsclone.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.data.datasource.post.post1
import com.example.jetnewsclone.model.post.Post
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    post: Post,
    isBookmarked: Boolean,
    toggleBookmark: (String) -> Unit,
    onClick: () -> Unit,
) {
    Row(
        modifier.fillMaxWidth().clickable { onClick() },
    ) {
        Image(painter = painterResource(post.imageThumbId), contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            PostTitle(title = post.title)
            PostAuthorAndReadTime(
                name = post.metadata.author.name,
                readTime = post.metadata.readTimeMinutes
            )
        }
        BookmarkIcon(isChecked = isBookmarked, onCheckChange = {
            toggleBookmark(post.id)
        })
    }
}

@Composable
private fun PostTitle(title: String) {
    Text(
        title,
        style = MaterialTheme.typography.titleMedium
    )
}

@Composable
fun PostAuthorAndReadTime(name: String, readTime: Int) {
    Text(
        text = "$name - $readTime",
        style = MaterialTheme.typography.labelSmall
    )
}

@MultiPreviews
@Composable
fun PostCardPreview() {
    JetNewTheme {
        Surface {
            PostCard(
                post = post1,
                isBookmarked = false,
                toggleBookmark = {}
            )
        }
    }
}

@MultiPreviews
@Composable
fun PostCardBookmarkedPreview() {
    JetNewTheme {
        Surface {
            PostCard(
                post = post1,
                isBookmarked = true,
                toggleBookmark = {}
            )
        }
    }
}
