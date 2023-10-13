package com.example.jetnewsclone.data.repository.interests

import kotlinx.coroutines.flow.Flow

interface InterestsRepository {
    fun getTopics(): Flow<Map<String, List<String>>>

    fun getSavedTopics(): Flow<Set<String>>

    fun saveTopic(topic: String)

    fun getPeople(): Flow<List<String>>

    fun getPublications(): Flow<List<String>>

    fun savePeople(people: String)

    fun savePublication(publication: String)
}
