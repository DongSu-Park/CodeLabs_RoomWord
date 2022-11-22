package kr.dev.dspark.roomwordsample.domain.usecase

import kr.dev.dspark.roomwordsample.data.model.WordEntity
import kr.dev.dspark.roomwordsample.data.repository.WordRepository
import javax.inject.Inject

class GetWordInsertUseCase @Inject constructor(private val wordRepository: WordRepository) {
    suspend fun execute(wordEntity: WordEntity) {
        wordRepository.wordInsert(wordEntity)
    }
}