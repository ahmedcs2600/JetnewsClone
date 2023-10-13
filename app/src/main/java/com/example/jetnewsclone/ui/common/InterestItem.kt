package com.example.jetnewsclone.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
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
fun InterestItem(
    title: String,
    isSaved: Boolean,
    onSaveButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.placeholder_1_1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = title,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 25.dp)
            )
            InterestSaveItem(
                isSaved = isSaved,
                onSaveButtonClick = onSaveButtonClick,
                modifier = Modifier.size(20.dp)
            )
        }
        Divider(
            Modifier.padding(start = 54.dp)
        )
    }
}

@MultiPreviews
@Composable
fun InterestItemPreview() {
    JetNewTheme {
        Surface {
            InterestItem(
                title = "Jetpack Compose",
                onSaveButtonClick = {},
                isSaved = true
            )
        }
    }
}
