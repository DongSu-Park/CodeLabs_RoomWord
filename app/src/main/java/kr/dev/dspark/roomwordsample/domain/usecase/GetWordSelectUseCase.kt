package kr.dev.dspark.roomwordsample.domain.usecase

import kr.dev.dspark.roomwordsample.data.model.WordEntity
import kr.dev.dspark.roomwordsample.data.repository.WordRepository
import javax.inject.Inject

class GetWordSelectUseCase @Inject constructor(private val wordRepository: WordRepository) {
    suspend fun execute(): List<WordEntity> {
        return wordRepository.wordSelect()
    }
}