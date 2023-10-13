package com.example.jetnewsclone.ui.interests

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnewsclone.ui.common.AppTopBar
import com.example.jetnewsclone.ui.theme.JetNewTheme
import com.example.jetnewsclone.ui.topics.TopicsRoute
import com.example.jetnewsclone.ui.topics.TopicsScreen
import com.example.jetnewsclone.utils.MultiPreviews

@Composable
fun InterestsScreen(
    tabs: List<TabContent>,
    openDrawer: () -> Unit,
    selectedTab: TabItem,
    onTabChange: (TabItem) -> Unit,
) {
    Scaffold(
        topBar = { AppTopBar(openDrawer = openDrawer) }
    ) { innerPadding ->
        val modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        InterestContent(
            tabs = tabs,
            selectedTab = selectedTab,
            modifier = modifier,
            onTabChange = onTabChange
        )
    }
}

@Composable
private fun InterestContent(
    tabs: List<TabContent>,
    selectedTab: TabItem,
    onTabChange: (TabItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        InterestsTabRow(tabs, selectedTab, onTabChange)
        tabs[selectedTab.ordinal].content()
    }
}

@Composable
private fun InterestsTabRow(tabs: List<TabContent>, selectedTab: TabItem, onTabChange: (TabItem) -> Unit) {
    TabRow(selectedTabIndex = selectedTab.ordinal) {
        for (tab in tabs) {
            Tab(selected = selectedTab == tab.tab, onClick = { onTabChange(tab.tab) }, content = {
                Text(
                    text = tab.tab.name,
                    modifier = Modifier.padding(6.dp),
                    style = MaterialTheme.typography.labelSmall
                )
            })
        }
    }
}

@MultiPreviews
@Composable
fun InterestsScreenPreview() {
    JetNewTheme {
        InterestsScreen(
            tabs = listOf(
                TabContent(TabItem.TOPICS) { Text(text = "Topics") },
                TabContent(TabItem.PEOPLE) { Text(text = "PEOPLE") },
                TabContent(TabItem.PUBLICATIONS) { Text(text = "PUBLICATIONS") }
            ),
            selectedTab = TabItem.TOPICS,
            openDrawer = {},
            onTabChange = {}
        )
    }
}
