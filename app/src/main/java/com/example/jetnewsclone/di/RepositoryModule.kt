package com.example.jetnewsclone.di

import com.example.jetnewsclone.data.repository.interests.InterestsRepository
import com.example.jetnewsclone.data.repository.interests.InterestsRepositoryImpl
import com.example.jetnewsclone.data.repository.post.PostsRepository
import com.example.jetnewsclone.data.repository.post.PostsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun bindPostRepository(repository: PostsRepositoryImpl): PostsRepository

    @Binds
    @ViewModelScoped
    fun bindInterestsRepository(repository: InterestsRepositoryImpl): InterestsRepository
}
