package com.example.jetnewsclone.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.R
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(openDrawer: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { TopBarTitle() },
        navigationIcon = { TopBarNavigationItem(openDrawer = openDrawer) },
        actions = { ActionSearchItem() }
    )
}

@Composable
private fun TopBarTitle() {
    Image(
        painter = painterResource(id = R.drawable.ic_jetnews_wordmark),
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
    )
}

@Composable
private fun TopBarNavigationItem(openDrawer: () -> Unit) {
    Image(
        modifier = Modifier.padding(start = 8.dp).clickable { openDrawer() },
        painter = painterResource(id = R.drawable.ic_jetnews_logo),
        contentDescription = null,
        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
    )
}

@Composable
private fun ActionSearchItem() {
    IconButton(onClick = {  }) {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
    }
}

@MultiPreviews
@Composable
fun AppTopBarPreview() {
    JetNewTheme {
        AppTopBar(openDrawer = {})
    }
}
