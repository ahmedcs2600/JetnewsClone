package com.example.jetnewsclone.ui.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun InterestSaveItem(
    isSaved: Boolean,
    onSaveButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val icon = if(isSaved) Icons.Filled.Done else Icons.Outlined.Add
    Surface(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            MaterialTheme.colorScheme.outline
        )
    ) {
        IconButton(onClick = onSaveButtonClick) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@MultiPreviews
@Composable
fun InterestSaveItemPreview() {
    JetNewTheme {
        InterestSaveItem(
            isSaved = false,
            onSaveButtonClick = {}
        )
    }
}
