package kr.dev.dspark.roomwordsample.domain.usecase

import kr.dev.dspark.roomwordsample.data.repository.WordRepository
import javax.inject.Inject

class GetWordDeleteAllUseCase @Inject constructor(private val wordRepository: WordRepository) {
    suspend fun execute() {
        wordRepository.wordDeleteAll()
    }
}