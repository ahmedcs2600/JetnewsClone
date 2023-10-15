package com.example.jetnewsclone.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetnewsclone.ui.Screen
import com.example.jetnewsclone.ui.detail.DetailRoute
import com.example.jetnewsclone.ui.detail.DetailScreen
import com.example.jetnewsclone.ui.home.HomeRoute
import com.example.jetnewsclone.ui.interests.InterestRoute

@Composable
fun JetNewsNavGraph(navController: NavHostController, openDrawer: () -> Unit) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        builder = {
            composable(route = Screen.Home.route) {
                HomeRoute(
                    openDrawer = openDrawer,
                    openDetails = { navController.navigate(route = Screen.Detail.route) }
                )
            }
            composable(route = Screen.Detail.route) {
                DetailRoute(onBack = {
                    navController.navigateUp()
                })
            }
            composable(route = Screen.Interests.route) {
                InterestRoute(openDrawer = openDrawer)
            }
        })
}
