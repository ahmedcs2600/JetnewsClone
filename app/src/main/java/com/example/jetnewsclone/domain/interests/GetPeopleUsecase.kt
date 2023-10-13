package com.example.jetnewsclone.domain.interests

import com.example.jetnewsclone.data.repository.interests.InterestsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPeopleUsecase @Inject constructor(private val repository: InterestsRepository) {
    operator fun invoke(): Flow<List<String>> {
        return repository.getPeople()
    }
}