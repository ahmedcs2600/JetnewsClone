package com.example.jetnewsclone.data.repository.interests

import com.example.jetnewsclone.data.datasource.interests.InterestsDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InterestsRepositoryImpl @Inject constructor(
    private val dataSource: InterestsDataSource
) : InterestsRepository {

    override fun getTopics(): Flow<Map<String, List<String>>> {
        return dataSource.getTopics()
    }

    override fun getSavedTopics(): Flow<Set<String>> {
        return dataSource.getSavedTopics()
    }

    override fun saveTopic(topic: String) {
        dataSource.saveTopic(topic)
    }

    override fun getPeople(): Flow<List<String>> {
        return dataSource.getPeople()
    }

    override fun getPublications(): Flow<List<String>> {
        return dataSource.getPublications()
    }

    override fun savePeople(people: String) {
        dataSource.savePeople(people)
    }

    override fun savePublication(publication: String) {
        dataSource.savePublication(publication)
    }
}
