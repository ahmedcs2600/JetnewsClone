package com.example.jetnewsclone.data.datasource.interests

import com.example.jetnewsclone.utils.addOrRemove
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class InterestsDataSourceImpl @Inject constructor() : InterestsDataSource {

    private val savedTopics = MutableStateFlow<Set<String>>(setOf())
    private val savedPeople = MutableStateFlow<Set<String>>(setOf())
    private val savedPublications = MutableStateFlow<Set<String>>(setOf())

    override fun getTopics(): Flow<Map<String, List<String>>> {
        return flow {
            delay(1000L)
            emit(topics)
        }
    }

    override fun getSavedTopics(): Flow<Set<String>> {
        return savedTopics
    }

    override fun getPeople(): Flow<List<String>> {
        return flow {
            delay(1000L)
            emit(people)
        }
    }

    override fun getPublications(): Flow<List<String>> {
        return flow {
            delay(1000L)
            emit(publications)
        }
    }

    override fun saveTopic(topic: String) {
        savedTopics.update { it.addOrRemove(topic) }
    }

    override fun savePeople(people: String) {
        savedPeople.update { it.addOrRemove(people) }
    }

    override fun savePublication(publication: String) {
        savedPublications.update { it.addOrRemove(publication) }
    }
}
