package com.example.jetnewsclone.ui.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun BookmarkIcon(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckChange: () -> Unit
) {
    IconButton(
        modifier = modifier,
        onClick = onCheckChange
    ) {
        Icon(
            imageVector = if (!isChecked) Icons.Filled.BookmarkBorder else Icons.Filled.Bookmark,
            contentDescription = null
        )
    }
}

@MultiPreviews
@Composable
fun BookmarkIconUnCheckedPreview() {
    JetNewTheme {
        Surface {
            BookmarkIcon(isChecked = false, onCheckChange = {})
        }
    }
}

@MultiPreviews
@Composable
fun BookmarkIconCheckedPreview() {
    JetNewTheme {
        Surface {
            BookmarkIcon(isChecked = true, onCheckChange = {})
        }
    }
}
