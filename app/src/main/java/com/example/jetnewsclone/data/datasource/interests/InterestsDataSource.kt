package com.example.jetnewsclone.data.datasource.interests

import kotlinx.coroutines.flow.Flow

interface InterestsDataSource {

    fun getTopics(): Flow<Map<String, List<String>>>

    fun getSavedTopics(): Flow<Set<String>>

    fun getPeople(): Flow<List<String>>

    fun getPublications(): Flow<List<String>>

    fun saveTopic(topic: String)

    fun savePeople(people: String)

    fun savePublication(publication: String)
}
