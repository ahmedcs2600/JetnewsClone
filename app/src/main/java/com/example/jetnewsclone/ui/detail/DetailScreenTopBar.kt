package com.example.jetnewsclone.ui.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.R
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailScreenTopBar(
    title: String,
    @DrawableRes image: Int,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = { TopBarTitle(
            title,
            image
        ) },
        navigationIcon = { NavigationBackButton(onBack) },
        modifier = modifier
    )
}

@Composable
private fun TopBarTitle(
    title: String,
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title)
    }
}

@Composable
private fun NavigationBackButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
    }
}

@MultiPreviews
@Composable
fun DetailScreenTopBarPreview() {
    JetNewTheme {
        DetailScreenTopBar(
            title = "Published in:\nAndroid Developers",
            image = R.drawable.icon_article_background,
            onBack = {}
        )
    }
}
