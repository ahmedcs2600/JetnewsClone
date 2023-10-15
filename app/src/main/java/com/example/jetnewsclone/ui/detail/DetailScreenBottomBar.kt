package com.example.jetnewsclone.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.FormatColorText
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.outlined.TextFormat
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
internal fun DetailScreenBottomBar() {
    Row(modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer).fillMaxWidth().padding(16.dp)) {
        BottomBarIcon(Icons.Outlined.ThumbUp)
        BottomBarIcon(Icons.Outlined.Bookmark)
        BottomBarIcon(Icons.Outlined.Share)
        BottomBarIcon(Icons.Outlined.FormatColorText)
    }
}

@Composable
private fun BottomBarIcon(
    image: ImageVector,
    onClick: () -> Unit = {},
) {
    IconButton(onClick = onClick) {
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
