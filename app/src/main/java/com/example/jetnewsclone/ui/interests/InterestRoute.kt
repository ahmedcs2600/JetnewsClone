package com.example.jetnewsclone.ui.interests

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.jetnewsclone.ui.people.PeopleRoute
import com.example.jetnewsclone.ui.publications.PublicationsRoute
import com.example.jetnewsclone.ui.topics.TopicsRoute

@Composable
fun InterestRoute(
    openDrawer: () -> Unit,
) {
    val tabs = remember { listOf(TabItem.TOPICS, TabItem.PEOPLE, TabItem.PUBLICATIONS) }
    val tabContent = remember { tabContent(tabs) }
    var selectedTab by remember { mutableStateOf(TabItem.TOPICS) }
    InterestsScreen(
        tabs = tabContent,
        openDrawer = openDrawer,
        selectedTab = selectedTab,
        onTabChange = { tab -> selectedTab = tab }
    )
}

fun tabContent(tabs: List<TabItem>): List<TabContent> {
    return tabs.map { tab ->
        val content: @Composable () -> Unit = when (tab) {
            TabItem.TOPICS -> { { TopicsRoute() } }

            TabItem.PEOPLE -> { { PeopleRoute() } }

            TabItem.PUBLICATIONS -> { { PublicationsRoute() } }
        }
        TabContent(tab = tab, content = content)
    }
}
