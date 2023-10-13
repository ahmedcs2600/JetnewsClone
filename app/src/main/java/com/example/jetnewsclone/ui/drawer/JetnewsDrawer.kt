package com.example.jetnewsclone.ui.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Interests
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.R
import com.example.jetnewsclone.ui.Screen
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun JetnewsDrawer(
    modifier: Modifier = Modifier,
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToInterest: () -> Unit,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet {
        LazyColumn(
            content = {
                item { Header() }
                item {
                    NavigationDrawerItem(
                        label = { Text(text = "Home") },
                        selected = currentRoute == Screen.Home.route,
                        onClick = { navigateToHome(); closeDrawer() },
                        icon = {
                            Icon(imageVector = Icons.Default.Home, contentDescription = null)
                        }
                    )
                }
                item {
                    NavigationDrawerItem(
                        label = { Text(text = "Interests") },
                        selected = currentRoute == Screen.Interests.route,
                        onClick = { navigateToInterest(); closeDrawer(); },
                        icon = {
                            Icon(imageVector = Icons.Default.Interests, contentDescription = null)
                        }
                    )
                }
            },
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
private fun Header() {
    Row(modifier = Modifier.padding(12.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_jetnews_logo), contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_jetnews_wordmark),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
        )
    }
}

@Composable
private fun MenuItem(isSelected: Boolean) {
    val surfaceColor =
        if (isSelected) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primaryContainer
    Surface(
        shape = RoundedCornerShape(32.dp),
        color = surfaceColor,
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize()
        ) {
            Icon(imageVector = Icons.Default.Home, contentDescription = null)
            Text("Home")
        }
    }
}


@MultiPreviews
@Composable
fun JetnewsDrawerPreview() {
    JetNewTheme {
        JetnewsDrawer(
            currentRoute = Screen.Home.route,
            navigateToHome = {},
            navigateToInterest = {},
            closeDrawer = {}
        )
    }
}