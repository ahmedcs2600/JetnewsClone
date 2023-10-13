package com.example.jetnewsclone.domain.posts

import com.example.jetnewsclone.data.repository.post.PostsRepository
import javax.inject.Inject

class ToggleFavouritesUsecase @Inject constructor(private val repository: PostsRepository) {
    suspend operator fun invoke(postId: String) {
        repository.toggleFavourites(postId)
    }
}