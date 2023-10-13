package com.example.jetnewsclone.data.datasource.post

import com.example.jetnewsclone.model.post.PostsFeed
import com.example.jetnewsclone.utils.addOrRemove
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor() : PostDataSource {

    private val favourites = MutableStateFlow<Set<String>>(setOf())

    override fun getPostFeed(): Flow<PostsFeed> {
        return flow {
            delay(1000L)
            emit(posts)
        }
    }

    override suspend fun toggleFavourites(postId: String) {
        favourites.update { it.addOrRemove(postId) }
    }

    override fun getFavourites(): Flow<Set<String>> {
        return favourites
    }
}
