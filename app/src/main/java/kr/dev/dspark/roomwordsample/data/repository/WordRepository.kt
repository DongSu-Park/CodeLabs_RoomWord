package kr.dev.dspark.roomwordsample.data.repository

import kr.dev.dspark.roomwordsample.data.model.WordEntity

interface WordRepository {
    suspend fun wordInsert(wordEntity: WordEntity)
    suspend fun wordSelect(): List<WordEntity>
    suspend fun wordDeleteAll()
}