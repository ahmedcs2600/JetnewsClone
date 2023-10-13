package com.example.jetnewsclone.di

import com.example.jetnewsclone.data.datasource.interests.InterestsDataSource
import com.example.jetnewsclone.data.datasource.interests.InterestsDataSourceImpl
import com.example.jetnewsclone.data.datasource.post.PostDataSource
import com.example.jetnewsclone.data.datasource.post.PostDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
interface DataSourceModule {

    @Binds
    @ViewModelScoped
    fun bindPostDataSource(dataSource: PostDataSourceImpl): PostDataSource

    @Binds
    @ViewModelScoped
    fun bindInterestsDataSource(dataSource: InterestsDataSourceImpl): InterestsDataSource

}
