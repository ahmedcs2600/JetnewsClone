package com.example.jetnewsclone.ui

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Interests: Screen("interests")
    object Detail: Screen("detail")
}