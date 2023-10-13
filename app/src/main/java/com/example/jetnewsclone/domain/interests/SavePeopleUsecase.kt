package com.example.jetnewsclone.domain.interests

import com.example.jetnewsclone.data.repository.interests.InterestsRepository
import javax.inject.Inject

class SavePeopleUsecase @Inject constructor(private val repository: InterestsRepository) {
    operator fun invoke(people: String) {
        repository.savePeople(people)
    }
}
