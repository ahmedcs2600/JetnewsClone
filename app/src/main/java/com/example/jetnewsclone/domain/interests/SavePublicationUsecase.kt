package com.example.jetnewsclone.domain.interests

import com.example.jetnewsclone.data.repository.interests.InterestsRepository
import javax.inject.Inject

class SavePublicationUsecase @Inject constructor(private val repository: InterestsRepository) {
    operator fun invoke(publication: String) {
        repository.savePublication(publication)
    }
}
