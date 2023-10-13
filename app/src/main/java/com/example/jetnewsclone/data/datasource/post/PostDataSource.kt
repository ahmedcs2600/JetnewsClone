package com.example.jetnewsclone.data.datasource.post

import com.example.jetnewsclone.model.post.PostsFeed
import kotlinx.coroutines.flow.Flow

interface PostDataSource {

    fun getPostFeed(): Flow<PostsFeed>

    suspend fun toggleFavourites(postId: String)

    fun getFavourites(): Flow<Set<String>>
}
