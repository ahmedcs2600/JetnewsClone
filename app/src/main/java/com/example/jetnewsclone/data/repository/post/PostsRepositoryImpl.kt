package com.example.jetnewsclone.data.repository.post

import com.example.jetnewsclone.data.datasource.post.PostDataSource
import com.example.jetnewsclone.model.post.PostsFeed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(private val dataSource: PostDataSource) :
    PostsRepository {
    override fun getPostFeed(): Flow<PostsFeed> {
        return dataSource.getPostFeed()
    }

    override suspend fun toggleFavourites(postId: String) {
         dataSource.toggleFavourites(postId)
    }

    override fun getFavourites(): Flow<Set<String>> {
        return dataSource.getFavourites()
    }
}
