package com.example.jetnewsclone.domain.interests

import com.example.jetnewsclone.data.repository.interests.InterestsRepository
import javax.inject.Inject

class SaveTopicUsecase @Inject constructor(private val repository: InterestsRepository) {
    operator fun invoke(topic: String) {
        repository.saveTopic(topic)
    }
}
