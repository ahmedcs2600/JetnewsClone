package com.example.jetnewsclone.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BackHand
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.R
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailScreenTopBar() {
    CenterAlignedTopAppBar(
        title = { TopBarTitle() },
        navigationIcon = { NavigationBackButton() }
    )
}

@Composable
private fun TopBarTitle() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.icon_article_background),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = "Published in:\nAndroid Developers")
    }
}

@Composable
private fun NavigationBackButton() {
    IconButton(onClick = {  }) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    }
}

@MultiPreviews
@Composable
fun DetailScreenTopBarPreview() {
    JetNewTheme {
        DetailScreenTopBar()
    }
}
