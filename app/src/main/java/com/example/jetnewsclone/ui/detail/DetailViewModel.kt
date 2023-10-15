package com.example.jetnewsclone.ui.detail

import androidx.lifecycle.ViewModel
import com.example.jetnewsclone.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(
        DetailUiState(
            toolbarTitle = "Published in:\nAndroid Developers",
            toolbarImage = R.drawable.icon_article_background,
            pageImage = R.drawable.post_4,
            pageTitle = "Locale changes and the AndroidViewModel antipattern",
            pageSubTitle = "TL;DR: Expose resource IDs from ViewModels to avoid showing absolete data.",
            userName = "Jose Alcerreca",
            date = "April 02",
            readTime = "1 min read",
            paragraph = listOf(
                "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
                "In a ViewModel, if you’re exposing data coming from resources (strings, drawables, colors…), you have to take into account that ViewModel objects ignore configuration changes such as locale changes. When the user changes their locale, activities are recreated but the ViewModel objects are not.",
            ),
        )
    )

    val uiState : StateFlow<DetailUiState> get() = _uiState
}