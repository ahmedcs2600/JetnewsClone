package com.example.jetnewsclone.domain.posts

import com.example.jetnewsclone.data.repository.post.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavouritesUsecase @Inject constructor(private val repository: PostsRepository) {
    operator fun invoke(): Flow<Set<String>> {
        return repository.getFavourites()
    }
}