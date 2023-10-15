package com.example.jetnewsclone.ui.detail

import androidx.annotation.DrawableRes

data class DetailUiState(
    val toolbarTitle: String,
    @DrawableRes val toolbarImage: Int,
    @DrawableRes val pageImage: Int,
    val pageTitle: String,
    val pageSubTitle: String,
    val userName: String,
    val date: String,
    val readTime: String,
    val paragraph: List<String>
)
