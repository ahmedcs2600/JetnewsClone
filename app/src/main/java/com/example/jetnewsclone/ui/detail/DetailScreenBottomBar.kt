package com.example.jetnewsclone.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
internal fun DetailScreenBottomBar() {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer).fillMaxWidth()) {
        BottomBarIcon(Icons.Outlined.ThumbUp)
        BottomBarIcon(Icons.Outlined.Bookmark)
        BottomBarIcon(Icons.Outlined.Share)
        //BottomBarIcon(Icons.Outlined.A)
    }
}

@Composable
private fun BottomBarIcon(image: ImageVector) {
    IconButton(onClick = {  }) {
        Icon(imageVector = image, contentDescription = null)
    }
}

@MultiPreviews
@Composable
fun DetailScreenBottomBarPreview() {
    JetNewTheme {
        DetailScreenBottomBar()
    }
}
