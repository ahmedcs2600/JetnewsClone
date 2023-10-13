package com.example.jetnewsclone.ui

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetnewsclone.ui.drawer.JetnewsDrawer
import com.example.jetnewsclone.ui.navigation.JetNewsNavGraph
import com.example.jetnewsclone.ui.navigation.JetnewsNavigationActions
import com.example.jetnewsclone.ui.theme.JetNewTheme
import kotlinx.coroutines.launch

@Composable
fun JetnewsApp() {
    JetNewTheme {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val navController = rememberNavController()
        val navigationActions = remember(navController) { JetnewsNavigationActions(navController) }
        val coroutineScope = rememberCoroutineScope()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: Screen.Home.route
        ModalNavigationDrawer(drawerContent = {
            JetnewsDrawer(
                currentRoute = currentRoute,
                navigateToHome = navigationActions.navigateToHome,
                navigateToInterest = navigationActions.navigateToInterests,
                closeDrawer = {
                    coroutineScope.launch { drawerState.close() }
                }
            )
        }, drawerState = drawerState) {
            JetNewsNavGraph(navController = navController, openDrawer = {
                coroutineScope.launch { drawerState.open() }
            })
        }
    }
}
