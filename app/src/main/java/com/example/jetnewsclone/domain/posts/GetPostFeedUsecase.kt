package com.example.jetnewsclone.domain.posts

import com.example.jetnewsclone.data.repository.post.PostsRepository
import com.example.jetnewsclone.model.post.PostsFeed
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostFeedUsecase @Inject constructor(private val repository: PostsRepository) {
    operator fun invoke(): Flow<PostsFeed> {
        return repository.getPostFeed()
    }
}